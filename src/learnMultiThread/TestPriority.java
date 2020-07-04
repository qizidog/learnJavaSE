package learnMultiThread;

/**
 * @author qizidog
 * @date 2020.04.28
 * 优先级
 * 优先级高的，执行的概率大，但不一定先执行
 */
public class TestPriority {
    public static void main(String[] args) {
        MyPriority mp = new MyPriority();
        Thread th1 = new Thread(mp, "high1");
        Thread th2 = new Thread(mp, "high2");
        Thread th3 = new Thread(mp, "high3");
        Thread th4 = new Thread(mp, "low1");
        Thread th5 = new Thread(mp, "low2");
        Thread th6 = new Thread(mp, "low3");
        
        // 设置优先级在start之前
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MAX_PRIORITY);
        th3.setPriority(Thread.MAX_PRIORITY);
        th4.setPriority(Thread.MIN_PRIORITY);
        th5.setPriority(Thread.MIN_PRIORITY);
        th6.setPriority(Thread.MIN_PRIORITY);
        
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }
}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+
                    "-->"+Thread.currentThread().getPriority());
        Thread.yield();
    }
}

