package learnMultiThread.juc.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : qizidog
 * @date : 2021-01-16 15:50
 * @description :
 **/

public class ListJUC {
    public static void main(String[] args) {
        testArrayList();  // 测试ArrayList

        // testVector();  // 测试Vector

        // testCopyOnWriteArrayList();  // 测试CopyOnWriteArrayList
    }

    public static void testCopyOnWriteArrayList() {  // CopyOnWriteArrayList是线程安全的
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                // 内部通过lock来实现并发控制
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void testVector() {  // Vector是线程安全的
        List<String> list = new Vector<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void testArrayList(){  // ArrayList线程不安全
        // 通过Collections.synchronizedList()来实现线程安全
        List<String> list = new ArrayList<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);  // 写在里面才会报错 ConcurrentModificationException 并发修改异常
            }, String.valueOf(i)).start();
        }

        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // System.out.println(list);  // 输出空list
    }
}
