package github.gx.ioserverstudy.aio.server;

import github.gx.ioserverstudy.tomcat.TomCatMethods;

/**
 * @program: socialcircle
 * @description: aio服务器启动类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 15:52
 **/
public class ServerMain {

    public static void main(String[] args) {
        // 书上为了防止 主线程关闭，所以启动无限长的等待？？
        SelfServer server = new AioServer();
        TomCatMethods.startDaemonAwaitThread();
    }
}
