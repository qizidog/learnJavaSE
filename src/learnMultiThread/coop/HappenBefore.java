package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.04
 * 指令重排：1、虚拟机层面    2、硬件层面
 */
public class HappenBefore {
    private static int a=0;
    private static boolean flag=false;
    public static void main(String[] args) {
       for(int i=0; i<15; i++) {
           a = 0;
           flag = false;
           
           Thread t1 = new Thread(()->{
               a = 1;
               flag = true;
           });

           Thread t2 = new Thread(()->{
               if(flag) {
                   a*=1;
               }
               if(a==0) {
                   System.out.println("happend before-->a="+a);
               }
           });
           
           t1.start();
           t2.start();
       }
       
    }
}
