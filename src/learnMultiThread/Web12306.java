package learnMultiThread;

public class Web12306 implements Runnable{
    private int num = 10;  // 共享变量
    
    public void run() {  // run方法不能抛出异常，且没有返回值
        while(num>0) {
            try {
                Thread.sleep(200); // 休眠100ms 由于延迟时间，可能造成多并发
            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
             
            this.num--;
            System.out.println(Thread.currentThread().getName()+"-->"+this.num);
        }
    }
    
    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web, "码畜").start();
        new Thread(web, "码蟥").start();
        new Thread(web, "码农").start();
        
    }
}

