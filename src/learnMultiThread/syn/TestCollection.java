package learnMultiThread.syn;

import java.util.ArrayList;

public class TestCollection {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        for(int i=0; i<1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    synchronized (al) {  // 锁住要修改的对象
                        // 数组扩容的时候，以及元素赋值的时候线程不安全
                        al.add(Thread.currentThread().getName());
//                    }
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("error!");
        }
        System.out.println(al.size());
    }
}
