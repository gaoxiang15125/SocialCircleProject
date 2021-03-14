package github.gx.ioserverstudy.aio.server.client;

import java.nio.channels.AsynchronousSocketChannel;

/**
 * @program: socialcircle
 * @description: 自定义客户端接口描述类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 16:31
 **/
public class AIOClient {

    private final AsynchronousSocketChannel client;

    public AIOClient() throws Exception {
        client = AsynchronousSocketChannel.open();
    }

//    public void connect(String host, int port) throws Exception {
//        client
//    }
}
