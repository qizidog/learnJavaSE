package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.03
 * 生产者消费者协作模型
 * 实现方法二：信号灯法
 */
public class TestCooperation02 {
    public static void main(String[] args) {
        TV tv = new TV();
        Player p = new Player(tv);
        Watcher w = new Watcher(tv);
        
        p.start();
        w.start();
    }
}

// 生产者 演员
class Player extends Thread{
    private TV tv;
    
    public Player(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
           tv.play("好的演员不拘一格"+i); 
        }
    }
}


// 消费者 观众
class Watcher extends Thread{
    private TV tv;
    
    public Watcher(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}


// 同一个资源 电视tv
class TV{
    String voice;
    // 信号灯
    // T 演员表演，观众等待
    // F 演员等待，观众观看
    boolean flag = true;
    
    public synchronized void play(String voice) {
        if (!flag) {
           try {
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } 
        }
        this.voice = voice;
        System.out.println("表演了->"+voice);
        this.notifyAll(); // 通知可以观看了
        this.flag=!this.flag;  // 切换红绿灯
    }
    
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
        System.out.println("listen->"+voice);
        this.notifyAll(); // 通知可以表演了
        this.flag=!this.flag;  // 切换红绿灯
    }
}

