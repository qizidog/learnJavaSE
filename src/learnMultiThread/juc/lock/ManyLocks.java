package learnMultiThread.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : qizidog
 * @date : 2021-01-19 15:51
 * @description :
 **/

public class ManyLocks {
    public static void main(String[] args) {
        Lock unfairLock = new ReentrantLock(/*false*/);  // 非公平锁
        Lock fairLock = new ReentrantLock(true);  // 公平锁
    }
}
