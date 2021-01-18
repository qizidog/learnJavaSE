package learnMultiThread.juc.collection;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : qizidog
 * @date : 2021-01-17 00:13
 * @description :
 * semaphore 信号量，并发场景下限流使用，我感觉像个阻塞队列
 * 跟阻塞队列的区别在于，队列入队是讲究顺序的（一定是先进先出），
 * 而semaphore似乎不太讲究顺序，只要有acquire的对象release了就可以让下一个进入
 **/

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");

                    TimeUnit.SECONDS.sleep(2);

                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();

        }
    }
}
