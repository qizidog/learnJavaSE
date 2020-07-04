package learnMultiThread;

import java.io.File;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author qizidog
 * @date 2020.04.24
 * 实现多线程的方法
 */

// 方法一：继承Thread类
public class TestCreateThread extends Thread{
    private String url;
    private String path;
    
    public TestCreateThread(String url, String path) {
        super();
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("thread  "+i);
//        }
        
        WebDownloader.download(url, path);
        System.out.println(new File(path).getName());
        
    }
    
    public static void main(String[] args) {
//        Thread th = new TestCreateThread();
//        th.start(); // 启动线程
////        th.run();  // 普通方法调用(会执行完run之后再进入下面的循环)
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main  "+i);
//        }
        
//        // 同时下载三张图片
//        Thread th1 = new TestCreateThread("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587639945479&di=3fd7113479eae1fc84902dd6867236df&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg", "src/learnMultiThread/pic1.jpg");
//        Thread th2 = new TestCreateThread("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587639945478&di=9644b9bdffe667bd2e6c55d4d405a513&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F21%2F09%2F01200000026352136359091694357.jpg", "src/learnMultiThread/pic2.jpg");
//        Thread th3 = new TestCreateThread("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587639945478&di=31048c970668375695e6cfa3aee8d1a7&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd62a6059252dd42a1c362a29033b5bb5c9eab870.jpg", "src/learnMultiThread/pic3.jpg");
//        // 好像是https协议有点问题，证书不对，需要在弄一下(改成http协议就好了)
//        th1.start();
//        th2.start();
//        th3.start();
        
        
        // 方法二
        Thread th4 = new Thread(new TestCreateThread2());  // new 代理类(new 实现类)
        th4.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程："+i);
        }
    }
}


// 方法二：实现runnable接口（推荐，可以避免java的单继承限制，并且方便共享资源）
class TestCreateThread2 implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: "+i);
        }
    }
    
}


// 方法三：实现callable接口（juc并发使用，暂时不要求掌握）
class TestCreateThread3 implements Callable<Boolean> /*throws Exception*/{
    public Boolean call() {
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
        return true;
    }
    
    public static void main(String[] args) {
        TestCreateThread3 th1 = new TestCreateThread3();
        TestCreateThread3 th2 = new TestCreateThread3();
        TestCreateThread3 th3 = new TestCreateThread3();
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        
        // 提交执行
        Future<Boolean> result1 = ser.submit(th1);
        Future<Boolean> result2 = ser.submit(th2);
        Future<Boolean> result3 = ser.submit(th3);
        
        // 获取结果
        try {
            Boolean ret1 = result1.get();
            Boolean ret2 = result2.get();
            Boolean ret3 = result3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // 关闭服务
       ser.shutdownNow();
        
    }
}
