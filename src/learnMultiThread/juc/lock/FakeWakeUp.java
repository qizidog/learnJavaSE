package learnMultiThread.juc.lock;

/**
 * @author : qizidog
 * @date : 2021-01-15 15:05
 * @description :
 **/

public class FakeWakeUp {

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

class Count{
    public int num=0;

    public synchronized void increase() throws InterruptedException {
        while (num!=0){  // 这里只能用while，不能用if，否则会出现虚假唤醒
            this.wait();  // 因为如果是if，当多个线程同时被唤醒时，会直接就执行下面，而while会再检查num的值
        }
        num++;
        System.out.println("执行了"+Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (num==0){  // 这里只能用while，不能用if，否则会出现虚假唤醒
            this.wait();  // 因为如果是if，当多个线程同时被唤醒时，会直接就执行下面，而while会再检查num的值
        }
        num--;
        System.out.println("执行了"+Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }
}
