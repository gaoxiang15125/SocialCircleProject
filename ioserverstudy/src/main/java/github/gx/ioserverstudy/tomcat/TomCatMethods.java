package github.gx.ioserverstudy.tomcat;

import github.gx.socialcircle.api.define.SystemDefine;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: socialcircle
 * @description: 模拟 TomCat 的某些操作做一些实现，辅助我们的程序
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 16:02
 **/
@Slf4j
public class TomCatMethods {

    private static volatile boolean isActive = true;

    private static final long SLEEP_TIME = 10000;
    /**
     * 模拟 TomCat 创建不会主动退出的子线程，保证整个程序监听不会停止
     */
    public static void startDaemonAwaitThread() {
        Thread awaitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                TomCatMethods.await();
            }
        });
    }

    private static void await() {
        long startTime = System.currentTimeMillis();
        try {
            while (isActive) {
                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {
            log.error("模拟Tomcat 创建的阻塞线程出现错误",e);
        } finally {
          log.info("程序执行时间为: {} s", (System.currentTimeMillis()-startTime)/1000);
        }
    }
}
