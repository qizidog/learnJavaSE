package learnMultiThread.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : qizidog
 * @date : 2021-01-15 15:05
 * @description :
 **/

public class FakeWakeUpJUC {

    public static void main(String[] args) {
        Count count = new Count();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    count.increase();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "++").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    count.decrease();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "--").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    count.increase();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "++1").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    count.decrease();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "--1").start();
    }

}

class CountJUC{
    private int num=0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increase() throws InterruptedException {
        lock.lock();  // 取代synchronized
        try {
            while (num!=0){  // 这里只能用while，不能用if，否则会出现虚假唤醒
                condition.await();  // 取代wait
            }
            num++;
            System.out.println("执行了"+Thread.currentThread().getName()+"=>"+num);
            condition.signalAll();  // 取代notifyAll
        }finally {
            lock.unlock();  // 取代synchronized
        }
    }

    public void decrease() throws InterruptedException {
        lock.lock();  // 取代synchronized
        try {
            while (num==0){  // 这里只能用while，不能用if，否则会出现虚假唤醒
                condition.await();  // 取代wait
            }
            num--;
            System.out.println("执行了"+Thread.currentThread().getName()+"=>"+num);
            condition.signalAll();  // 取代notifyAll
        }finally {
            lock.unlock();  // 取代synchronized
        }

    }
}
