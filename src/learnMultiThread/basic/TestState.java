package learnMultiThread.basic;

/**
 * @author qizidog
 * @date 2020.04.28
 * 测试线程状态
 */
public class TestState {
    public static void main(String[] args) {
         Thread th = new Thread(()->{
             System.out.println("this is a thread.");
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         });
         System.out.println(th.getState()); // new
         
         th.start();
         System.out.println(th.getState()); // runnable
         
         System.out.println(Thread.activeCount()); // 2 活动的线程数
         
         try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         System.out.println(th.getState()); // timed_waiting
         
         try {
             Thread.sleep(2500);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("test");
         try {
            th.sleep(3000);  // sleep是一个静态方法，不过也可以通过thread实例来调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         System.out.println(th.getState()); // terminated
         
    }
}
