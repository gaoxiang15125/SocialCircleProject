package github.gx.ioserverstudy.aio.server;

/**
 * @program: socialcircle
 * @description: 自定义服务器接口描述类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 14:12
 **/
public interface SelfServer {

    void init(int port);

    void start();

    void stop();
}
