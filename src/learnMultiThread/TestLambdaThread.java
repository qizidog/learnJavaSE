package learnMultiThread;

/**
 * @author qizidog
 * @date 2020.04.26
 * lambda表达式简化（用一次）线程的使用
 */
public class TestLambdaThread {
    // 静态内部类(好处：不使用的话则不会编译)
    static class Test implements Runnable{
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("内部"+i);
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {

        
        class Test2 implements Runnable{  // 局部内部类
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("局部内部类"+i);
                    
                }
            }
        }
        
        // 调用静态内部类
        new Thread(new Test()).start();
        
        // 调用局部内部类
        new Thread(new Test2()).start();;
        
        // 调用匿名内部类（必须借助接口或父类）
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("匿名内部类"+i);
                }
            }
        }).start();
        
        // lambda表达式简化(lambda推导必须存在类型，接口只有一个方法才能使用，jdk8)
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("lambda推导"+i);
            }
        }).start();
    }
}
