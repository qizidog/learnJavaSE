package learnMultiThread;

/**
 * @author qizidog
 * @date 2020.04.27
 * 终止线程的方法：
 * 1.线程执行完毕
 * 2.外部标识干涉
 * 3.stop destroy方法（不推荐）
 */
public class TerminateThread implements Runnable{
    private boolean flag = true;
    public void run() {
        int i = 0;
        while(flag) {
            System.out.println(i++);
//            try {
//                Thread.currentThread().sleep(10);
//            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }
        
    }
    
    public void set_flag(boolean flag) {
        this.flag = flag;
        System.out.println("flag:" + this.flag);
    }
    
    public void terminate() {
        this.flag = false;
    }
    
    public void sleep(int t) {
        try {
            Thread.currentThread().sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread();
        new Thread(tt).start();
        
        for (int i = 0; i < 30; i++) {
            System.out.println("main "+i);
        }
        tt.set_flag(false);
        System.out.println("start");
        tt.set_flag(true);
        
        for (int i = 0; i < 30; i++) {
            System.out.println("main two "+i);
        }
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        tt.terminate();
        
    }
}
