package learnMultiThread.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qizidog
 * @date 2020.05.09
 * 学习内部实现了并发控制的同步容器
 */
public class TestSynContainer {
    public static void main(String[] args) {
//        syn01();
        syn02();
    }
    
    static void syn01(){
        List<String> list = new ArrayList<String>();
        for(int i=0; i<1000; i++) {
            new Thread(()->{
                synchronized (list) { // 非同步容器，需要自己加锁
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {  // 避免线程中还没有添加完元素就print出了size结果
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size01:"+list.size());
    }
    
    static void syn02(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for(int i=0; i<1000; i++) {
            new Thread(()->{
//                synchronized (list) { // 同步容器，内部实现了锁，直接使用即可
                    list.add(Thread.currentThread().getName());
//                }
            }).start();
        }try {  // 避免线程中还没有添加完元素就print出了size结果
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size02:"+list.size());
    }
}
