package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.09
 * 可重入锁和不可重入锁的简单实现
 */
public class TestRelock {
    Lock lock = new Lock();
    Relock relock = new Relock();
    
    // 主程序
    public static void main(String[] args) throws InterruptedException {
        TestRelock tl = new TestRelock();
        tl.testlock();  // 不可重入锁测试(程序无法自动结束)
//        tl.testrelock();  // 可重入锁测试(程序可自动结束)
    }
    
    
    // 不可重入锁
    public void testlock() throws InterruptedException {
        lock.lock();
        System.out.println("locking.....");
        testlock2();  // 检查不可重入锁的使用情况
        lock.unlock();
    }
    
    public void testlock2() throws InterruptedException {
        lock.lock();  // 此处会进入死循环
        System.out.println("locking2.....");
        lock.unlock();
    }
    
    
    // 可重入锁
    public void testrelock() throws InterruptedException {
        relock.lock();
        System.out.println("relocking...");
        testrelock2();  // 检查可重入锁的使用情况
        relock.unlock();
    }
    
    public void testrelock2() throws InterruptedException {
        relock.lock();
        System.out.println("relocking2...");
        relock.unlock();
    }
}

// 不可重入锁
class Lock{
    private boolean flag = false;
    public synchronized void lock() throws InterruptedException {
        while (flag) {
            wait();
        }
        flag = true;
    }
    
    public synchronized void unlock() {
        flag = false;
        notify();
    }
}

// 可重入锁
class Relock{
    private boolean flag = false;
    private int holdNums = 0;
    private Thread lockedBy = null;
    
    public synchronized void lock() throws InterruptedException {
        Thread th = Thread.currentThread();
        while(flag && lockedBy!=th) {
            wait();
        }
        flag = true;
        lockedBy = th;
        holdNums++;
    }
    
    public synchronized void unlock() {
        if(lockedBy==Thread.currentThread()) {
            holdNums--;
            if(holdNums==0) {
                flag = false;
                lockedBy = null;
                notify();
            }
        }
    }
}
