package github.gx.ioserverstudy.aio.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: socialcircle
 * @description: 使用 JDK 提供的 AIO 模型 实现一个 AIO 服务器
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 14:05
 **/
@Slf4j
public class AioServer implements SelfServer {

    int port;

    /**
     * 看起来像是线程池之类的东西
     */
    ExecutorService executorService;

    /**
     * 异步通道，提交任务并分派线程池进行处理，AIO 实现相关类
     */
    AsynchronousChannelGroup threadGroup;

    /**
     * 用于绑定异步通道的 Socket
     */
    AsynchronousServerSocketChannel server;

    /**
     * 描述服务器地址信息 IP地址 + port 端口
     */
    InetSocketAddress socketAddress;

    /**
     * 初始化 AIO 服务器相关信息
     * @param port
     */
    @Override
    public void init(int port) {
        log.info("创建监听{} 端口的 AIO模型服务器", port);
        try {
            this.port = port;
            // 初始化 AIO 相关组件
            executorService = Executors.newCachedThreadPool();
            // 使用给定的线程池创建 异步通道
            threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
            // 获取一个用来在 应用层与传输层进行处理的 套接字对象
            server = AsynchronousServerSocketChannel.open(threadGroup);
            socketAddress = new InetSocketAddress(port);
            log.info("AIO 服务器相关对象创建成功");

            // 为 AIO 服务器设置默认的数据处理方式
            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                // TODO 原代码看起来逻辑像是没有 处理读出来的内容
                final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    // 如果缓冲区不足会发生什么？？ 不能 get
                    // TODO 暂时不考虑诸如 缓存不足、重复读取等问题
                    // TODO 修改为 按照 Future 控制读取数据并进行返回
                    try {
                        buffer.clear();
                        result.read(buffer).get();
                        buffer.flip();
                        result.write(buffer);
                        buffer.flip();
                    } catch (Exception e) {
                        log.error("读取输出网络传输数据过程出现异常", e);
                    } finally {
                        try{
                            result.close();
                            // 为什么这里重新设置？？
                            server.accept(null, this);
                        } catch (Exception e) {
                            log.error("关闭单次IO，重设 handler 过程出现异常", e);
                        }
                    }
                    log.info("接受——返回数据完成");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    log.error("I/O操作过程出现错误", exc);
                }
            });
        } catch (Exception e) {
            log.error("创建 AIO 服务相关对象过程出现错误 ", e);
        }
    }

    /**
     * 启动 AIO 服务器
     */
    @Override
    public void start() {
        log.info("启动 AIO 服务器");
        try {
            server.bind(socketAddress);
            log.info("AIO 服务器启动成功");
        } catch (IOException e) {
            log.error("AIO 服务器启动过程出现错误 ", e);
        }
    }

    @Override
    public void stop() {

    }

}
