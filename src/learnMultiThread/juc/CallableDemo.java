package learnMultiThread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author : qizidog
 * @date : 2021-01-18 00:35
 * @description :
 * callable的非线程池调用方法
 **/

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable() {}).start();
        // new Thread(new FutureTask<>(Callable)).start();
        // FutureTask实现了runnable接口，并且有一个传入callable的构造函数（Adapter模式）

        MyThread myThread = new MyThread();
        FutureTask<Object> futureTask = new FutureTask<>(myThread);

        new Thread(futureTask).start();

        // get方法可能会产生阻塞，他会等待线程的结果返回
        System.out.println((String) futureTask.get());

        System.out.println("程序结束");
    }

}

class MyThread implements Callable<Object>{
    @Override
    public Object call() throws Exception {
        System.out.println("执行call方法");
        TimeUnit.SECONDS.sleep(3);  // 等待3s验证get阻塞
        return "qizidog";
    }
}
