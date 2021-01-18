package learnMultiThread.juc.collection;

import java.util.concurrent.CountDownLatch;

/**
 * @author : qizidog
 * @date : 2021-01-16 17:31
 * @description :
 * CountDownLatch只能使用一次，用完一次倒数就报废了
 **/

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println("第"+Thread.currentThread().getName()+"个人走出去了");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();  // 等待计数器变为0

        System.out.println("关门了");
    }
}
