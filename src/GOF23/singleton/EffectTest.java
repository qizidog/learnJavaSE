package GOF23.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author qizidog
 * @date 2020.05.27
 * 测试多线程环境下，各种单例模式的效率（使用countdownlatch）
 */
public class EffectTest {
    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        int num = 20;
        CountDownLatch cd = new CountDownLatch(num);
        
        for (int i=0; i<num; i++) {
            new Thread(()->{
                for(int j=0; j<1000000; j++) {
                    SingletonDemo01 s1 = SingletonDemo01.getInstance();
//                    SingletonDemo02 s2 = SingletonDemo02.getInstance();
//                    SingletonDemo03 s3 = SingletonDemo03.getInstance();
//                    SingletonDemo04 s4 = SingletonDemo04.getInstance();
//                    SingletonDemo05 s5 = SingletonDemo05.getInstance();
                    
                }
                cd.countDown();  // 减一次
            }).start();
            
        }
        
        cd.await();  // 阻断线程，知道倒数计数变为0
        
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        
    }
}
