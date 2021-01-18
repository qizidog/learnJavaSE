package learnMultiThread.juc.collection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : qizidog
 * @date : 2021-01-16 22:43
 * @description :
 * 循环屏障，可重复使用
 * 在指定个数线程抵达前，抵达屏障的线程保持等待，待数量充足后才破除屏障，各线程同时唤醒，继续执行
 **/

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("第一阶段工作完成，开始下一阶段");
        });

        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(4, () -> {
            System.out.println("===========再来一次===========");

            for (int i = 1; i <= 4; i++) {
                final int temp = i;  // 最好是定义成常量，否则jdk1.8之前会报错
                new Thread(()->{
                    System.out.println("完成第一阶段工作=>"+temp+"/4");

                    try {
                        cyclicBarrier.await();  // 计数+1，等待屏障破除
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.println("完成第二阶段工作=>"+temp+"/4");
                }).start();
            }

        });

        SoutByOrder soutByOrder = new SoutByOrder(cyclicBarrier, cyclicBarrier2);

        soutByOrder.sout();

    }
}

class SoutByOrder{
    CyclicBarrier cyclicBarrier;
    CyclicBarrier cyclicBarrier2;

    public SoutByOrder(CyclicBarrier cyclicBarrier, CyclicBarrier cyclicBarrier2) {
        this.cyclicBarrier = cyclicBarrier;
        this.cyclicBarrier2 = cyclicBarrier2;
    }

    public synchronized void sout(){
        for (int i = 1; i <= 4; i++) {
            final int temp = i;  // 最好是定义成常量，否则jdk1.8之前会报错
            new Thread(()->{
                System.out.println("完成第一阶段工作=>"+temp+"/4");

                try {
                    cyclicBarrier.await();  // 计数+1，等待屏障破除
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("完成第二阶段工作=>"+temp+"/4");
                try {
                    cyclicBarrier2.await();  // 计数+1，等待屏障破除
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
