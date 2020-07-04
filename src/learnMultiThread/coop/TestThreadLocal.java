package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.08
 * ThreadLocal表示每个线程自身的本地、局部存储区域
 * 三个常用方法：set/get/initialValue
 */
public class TestThreadLocal {
    // 官方推荐使用  private static 修饰
//    private static ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>();  // 默认值为null      
    
    // 用匿名函数的形式修改默认的初始值
//    private static ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>() {
//        protected Integer initialValue() {
//            return 998;  // 修改默认值为998
//        }
//    };      
    
    // jdk1.8之后的新方法修改默认初始值
//    private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(()->{
//        return 999;  // 其实还可以省略，箭头后直接写999就行
//    }); 
        
    private static ThreadLocal<Integer> threadlocal = ThreadLocal.withInitial(()->996);
    
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadlocal.get());
        
        threadlocal.set(1026); // 更改
        System.out.println(Thread.currentThread().getName()+"-->"+threadlocal.get());
        
        // new 一个线程
        new Thread(()->{
            threadlocal.set(2222); // 更改
            System.out.println(Thread.currentThread().getName()+"-->"+threadlocal.get());
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->"+threadlocal.get());
            }
        }).start();
    }
}
