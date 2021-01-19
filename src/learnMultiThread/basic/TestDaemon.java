package learnMultiThread.basic;

/**
 * @author qizidog
 * @date 2020.04.30
 * Daemon守护线程，是为用户线程而存在的，jvm停止时不必等待守护线程执行完毕
 * 创建的线程默认为是用户线程
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        god.setDaemon(true);  // 设置为守护线程
        You2 you = new You2();
        god.start();
        you.start();
    }
}

class You2 extends Thread{
    public void run() {
        for (int i = 0; i < 365; i++) {
           System.out.println("happy life "+i);
        }
        System.out.println("life end...");
    }
}

class God extends Thread{
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("god bless you " + i);
        }
    }
}
