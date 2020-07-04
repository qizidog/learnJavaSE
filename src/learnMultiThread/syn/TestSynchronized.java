package learnMultiThread.syn;

/**
 * @author qizidog
 * @date 2020.04.30
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class TestSynchronized {
    public static void main(String[] args) {
        SafeWeb12306 web = new SafeWeb12306(); 
        new Thread(web, "p1").start();
        new Thread(web, "p2").start();
        new Thread(web, "p3").start();
        new Thread(web, "p4").start();
    }
}

class SafeWeb12306 implements Runnable{
    private int ticketNum = 20;
    private boolean flag = true;
    @Override
    public void run() {
//        while (ticketNum>0) {
//            getTicket();
//        }
        
        while(flag) {  // while必须写在这里， 不能写到方法里面，否则一次调用的方法始终没有结束，则不能切换到其他线程
//            getTicket2();
            getTicket3();
        }
    }
    
    private synchronized void getTicket() {
//        while(ticketNum>0) {  // while不能写到这里
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
          System.out.println("tickets left: "+ --ticketNum +"-->"+ Thread.currentThread().getName());
          
          try {
              Thread.sleep(50);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
    }
//        }
    
    public synchronized void getTicket2() {
        
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(ticketNum<=0) {
            flag = false;
            return;  // 记得要写return，否则后面的部分还是会被执行
        }

        System.out.println("tickets left: "+ --ticketNum +"-->"+ Thread.currentThread().getName());
        
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void getTicket3() {  // 优质代码(双重检测)
        // 开始延时
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(ticketNum<=0) {
            flag = false;
            return;  // 双重检测，可以提高ticketNum=1->0临界状态时的效率
        }
    synchronized(this){  // 锁定区块 
        if(ticketNum<=0) {
            flag = false;
            return;  // 记得要写return，否则后面的部分还是会被执行
        }
        try {  // 中间延时
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tickets left: "+ --ticketNum +"-->"+ Thread.currentThread().getName());
    }
        
        // 结束延时
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
