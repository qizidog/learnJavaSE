package learnMultiThread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : qizidog
 * @date : 2021-01-18 23:40
 * @description :
 * Volatile及CAS原子操作
 **/

public class VolatileDemo {
    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        // demo01();
        // demo02();
        demo03();
    }

    public static void demo01() throws InterruptedException {
        // 测试volatile具有可见性
        new Thread(()->{
            while (num==0){

            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        num = 1;
    }

    public static void demo02() throws InterruptedException {
        // 验证volatile不具备原子性
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    // synchronized(VolatileDemo.class) {  // synchronized可以保证原子性
                        num++;
                    // }
                }
            }).start();
        }

        while (Thread.activeCount()>2){  // java至少有main和jvm两个线程在运转
            // 只要还有线程在执行，就等待他们结束
            Thread.yield();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(num);  // 输出值不稳定
    }

    public static void demo03() throws InterruptedException {
        // 保证多线程操作原子性的方法
        AtomicInteger atomicInteger = new AtomicInteger(num);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicInteger.incrementAndGet();  // 相当于++i
                    // atomicInteger.getAndIncrement();  // 相当于i++
                    // atomicInteger.addAndGet(1);  // 先加再返回加后的值
                    // atomicInteger.getAndAdd(1);  // 返回加前的值并加
                }
            }).start();
        }

        while (Thread.activeCount()>2){  // java至少有main和jvm两个线程在运转
            // 只要还有线程在执行，就等待他们结束
            Thread.yield();
        }

        num = atomicInteger.get();
        System.out.println(num);
    }

}
