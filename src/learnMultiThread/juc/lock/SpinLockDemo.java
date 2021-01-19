package learnMultiThread.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : qizidog
 * @date : 2021-01-19 17:55
 * @description :
 * 手动实现自旋锁
 **/

public class SpinLockDemo {
    public static void main(String[] args) throws InterruptedException {
        MySpinLock lock = new MySpinLock();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"成功占有锁");
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+"请求释放锁");
                lock.unlock();
            }

        }, "A").start();

        TimeUnit.SECONDS.sleep(1);  // 休眠1s，确保第一个线程先占有锁

        new Thread(()->{
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"成功占有锁");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+"请求释放锁");
                    lock.unlock();
                }
        }, "B").start();
    }
}

class MySpinLock{
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"请求获取锁");
        while (!atomicReference.compareAndSet(null, thread)){
            // 如果真实值不是所期望的null值，自旋（死循环）
        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"释放锁");
        atomicReference.compareAndSet(thread, null);
    }
}
