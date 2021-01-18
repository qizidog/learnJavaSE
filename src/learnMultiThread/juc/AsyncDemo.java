package learnMultiThread.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author : qizidog
 * @date : 2021-01-18 22:04
 * @description :
 * 异步回调
 **/

public class AsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // testRunAsync();
        testSupplyAsync();
    }

    public static void testRunAsync() throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调 runAsync, 传入一个runnable
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                // 模拟异步干别的事情
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "=>runAsync=>Void");
        });

        try {
            // 模拟主线程继续干别的事情
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        voidCompletableFuture.get();  // 等主线程干完别的事情后，阻塞获取异步执行的结果

        System.out.println("1111111");
    }

    public static void testSupplyAsync() throws ExecutionException, InterruptedException {
        /*// 有返回值的异步回调 supplyAsync, 传入一个supplier
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟异步干别的事情
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=>supplyAsync=>String");
            int a = 1/0;
            return "qizidog";
        });

        // 明确当异步线程执行完成之后需要做的事情, 传入一个BiConsumer
        CompletableFuture<String> whenComplete = supplyAsync.whenComplete((t, u) -> {
            System.out.println("执行成功，t=>" + t);  // 执行成功的结果
            System.out.println("抛出异常，u=>" + u);  // 执行失败时的异常
        });

        // 明确当发生异常时要做的事情, 传入一个Throwable
        CompletableFuture<String> exceptionally = whenComplete.exceptionally((e) -> {
            System.out.println("e.getMessage=>" + e.getMessage());
            return "404";
        });

        // System.out.println("返回值1=>"+supplyAsync.get());  // 由于未明确异常发生时应当如何处理，故遇到异常则会抛出报错
        // System.out.println("返回值2=>"+whenComplete.get());  // 由于未明确异常发生时应当如何处理，故遇到异常则会抛出报错
        System.out.println("返回值3=>"+exceptionally.get());  // 不发生异常时返回qizidog，发生异常时返回404*/

        // 将上面一段转换为流式编程如下所示
        System.out.println("返回值=>"+CompletableFuture.supplyAsync(() -> {  // 明确异步线程需要做的事
            try {
                // 模拟异步干别的事情
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=>supplyAsync=>String");
            int a = 1 / 0;
            return "qizidog";
        }).whenComplete((t, u) -> {  // 明确当异步线程执行完成之后需要做的事情
            System.out.println("执行成功，t=>" + t);  // 执行成功的结果
            System.out.println("抛出异常，u=>" + u);  // 执行失败时的异常
        }).exceptionally((e) -> {  // 明确当发生异常时要做的事情
            System.out.println("e.getMessage=>" + e.getMessage());
            return "404";
        }).get());

        System.out.println("===由于get阻塞，现在起倒数10秒后才结束程序===");
        try {
            // 模拟主线程继续干别的事情
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========over========");
    }
}
