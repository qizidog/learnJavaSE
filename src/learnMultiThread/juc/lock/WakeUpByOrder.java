package learnMultiThread.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : qizidog
 * @date : 2021-01-15 16:21
 * @description :
 * 测试ReentrantLock可重入锁
 **/

public class WakeUpByOrder {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                trafficLight.green();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                trafficLight.yellow();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                trafficLight.red();
            }
        }).start();
    }
}

class TrafficLight{
    private int mode = 0;
    private Lock lock = new ReentrantLock();
    Condition greenCon = lock.newCondition();
    Condition yellowCon = lock.newCondition();
    Condition redCon = lock.newCondition();

    public void green(){
        lock.lock();
        try{
            while (mode!=0){
                greenCon.await();
            }
            System.out.println("现在是green灯=>0");
            mode = 1;
            yellowCon.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void yellow(){
        lock.lock();
        try{
            while (mode!=1){
                yellowCon.await();
            }
            System.out.println("现在是yellow灯=>1");
            mode = 2;
            redCon.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void red(){
        lock.lock();
        try{
            while (mode!=2){
                redCon.await();
            }
            System.out.println("现在是red灯=>2");
            mode = 0;
            greenCon.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
