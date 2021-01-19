package learnMultiThread.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author : qizidog
 * @date : 2021-01-19 23:43
 * @description :
 * 测试死锁，以及使用jps和jstack定位死锁错误
 **/

public class DeadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Dead dead = new Dead("A", "B");
        new Thread(()->{
            dead.test1();
        }, "t1").start();

        new Thread(()->{
            dead.test2();
        }, "t2").start();
    }

}

class Dead{
    private String str1;
    private String str2;

    public Dead(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
    }

    public void test1(){
        System.out.println(Thread.currentThread().getName()+"尝试获取str1");
        synchronized (str1){
            System.out.println(Thread.currentThread().getName()+"获得str1："+str1);

            try {
                TimeUnit.SECONDS.sleep(3);  // 休眠一下，确保死锁发生
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"尝试获取str2");
            synchronized (str2){
                System.out.println(Thread.currentThread().getName()+"获得str2："+str2);
            }
            System.out.println(Thread.currentThread().getName()+"释放str2");
        }
        System.out.println(Thread.currentThread().getName()+"释放str1");
    }

    public void test2(){
        System.out.println(Thread.currentThread().getName()+"尝试获取str2");
        synchronized (str2){
            System.out.println(Thread.currentThread().getName()+"获得str2："+str2);

            System.out.println(Thread.currentThread().getName()+"尝试获取str1");
            synchronized (str1){
                System.out.println(Thread.currentThread().getName()+"获得str1："+str1);
            }
            System.out.println(Thread.currentThread().getName()+"释放str1");
        }
        System.out.println(Thread.currentThread().getName()+"释放str2");
    }
}
