package learnMultiThread.juc;

import java.util.concurrent.*;

/**
 * @author : qizidog
 * @date : 2021-01-17 20:07
 * @description :
 **/

public class ExecutorsDemo {
    public static void main(String[] args) {
        // executorsTest();
        threadPoolExecutorTest();
    }

    /**
     * 阿里巴巴java开发手册中明确要求，不得使用Executors创建线程池，
     * 因为高并发环境下容易造成OOM的问题
     */
    public static void executorsTest(){
        // 三大方法
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();  // 单个线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);  // 指定数量的线程
        ExecutorService threadPool = Executors.newCachedThreadPool();  // 可伸缩的，自适应的
        /*ExecutorService threadPool = Executors.newScheduledThreadPool();  // 周期性线程池（暂时不知道怎么用）*/
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }

    /**
     * 应使用ThreadPoolExecutor创建线程池，手动配置线程池的参数
     */
    public static void threadPoolExecutorTest(){
        System.out.println(Runtime.getRuntime().availableProcessors());  // 获得CPU核数
        System.out.println(Runtime.getRuntime().totalMemory());

        // 七大参数
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            2, // int corePoolSize, 核心线程的数量
            5, // int maximumPoolSize, 线程池的最大线程容量
            3, // long keepAliveTime, 触发非核心线程后，非核心线程的保持时间
            TimeUnit.SECONDS, // TimeUnit unit, 保持时间的单位
            new LinkedBlockingQueue<>(4), // BlockingQueue<Runnable> workQueue, 等待区的线程容量
            Executors.defaultThreadFactory(), // ThreadFactory threadFactory, 线程创建工厂，都用这个
            new ThreadPoolExecutor.AbortPolicy() // RejectedExecutionHandler handler, 拒绝策略
        );
        /* 四种拒绝策略
         * new ThreadPoolExecutor.AbortPolicy()  不处理超出限制的线程，并抛出异常
         * new ThreadPoolExecutor.DiscardPolicy()  不处理超出限制的线程，不抛出异常
         * new ThreadPoolExecutor.CallerRunsPolicy()  将超出数量限制的线程丢回给线程产生出执行
         * new ThreadPoolExecutor.DiscardOldestPolicy()  将等待队列的首个元素丢弃，并尝试执行这个超出数量限制的线程
         */

        /*
         * 当请求的线程数量大于核心线程数与等待区线程容量之和时，才会启用多于核心线程数个数的线程；
         * 最多启用线程池最大线程容量个线程
         * 当请求的线程数量大于线程池最大线程容量与等待区线程容量之和时，会启用拒绝策略
         */
        try {
            // i = 1时，最多会启动 1 个线程
            // i = 2-6时，最多会启动 2 个线程
            // i = 7时，最多会启动 3 个线程
            // i = 8时，最多会启动 4 个线程
            // i = 9时，最多会启动 5 个线程
            // i > 9时，拒绝策略生效
            for (int i = 0; i < 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
