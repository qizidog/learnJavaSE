package learnMultiThread.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author : qizidog
 * @date : 2021-01-18 23:40
 * @description :
 **/

public class VolatileDemo {
    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        // demo01();
        demo02();
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

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(num);  // 输出值不稳定
    }


    }
