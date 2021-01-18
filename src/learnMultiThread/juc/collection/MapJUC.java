package learnMultiThread.juc.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : qizidog
 * @date : 2021-01-16 16:49
 * @description :
 **/

public class MapJUC {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
        Map<String, String> map = new ConcurrentHashMap<>();  // key&value都不可为null

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,5), new String(""));
                System.out.println(map);
            }).start();
        }
    }
}
