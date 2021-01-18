package learnMultiThread.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : qizidog
 * @date : 2021-01-17 14:43
 * @description :
 * 测试读写锁
 * 多个读锁（共享锁）可同时获取
 * 写锁只能单独获取（独占锁）
 **/

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 4; i++) {
            int temp = i;
            new Thread(()->{
                myCache.put(String.valueOf(temp), String.valueOf(temp));
            }).start();
        }

        for (int i = 1; i <= 4; i++) {
            int temp = i;
            new Thread(()->{
                myCache.get(String.valueOf(temp));
            }).start();
        }
    }
}

class MyCache{
    ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private volatile Map<String, Object> cache = new HashMap<>();

    public void put(String k, Object v){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+k);
            cache.put(k, v);
            System.out.println(Thread.currentThread().getName()+"写入OK"+k);
        }finally {
            rwlock.writeLock().unlock();
        }
    }

    public Object get(String k){
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+k);
            cache.get(k);
            System.out.println(Thread.currentThread().getName()+"读取OK"+k);
            return null;
        } finally {
            rwlock.readLock().unlock();
        }
    }

}
