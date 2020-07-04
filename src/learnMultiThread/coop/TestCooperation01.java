package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.03
 * 生产者消费者协作模型
 * 实现方法一：管程法
 */
public class TestCooperation01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer(20);
        new Productor(container).start();
        new Consumer(container).start();
    }
}


// 生产者
class Productor extends Thread{
    private SynContainer container;
    
    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        // 开始生产
        for (int i = 0; i < 100; i++) {
            System.out.println("开始生产第"+i+"个馒头"); 
            container.push(new Steamedbun(i));
        }
    }
}


// 消费者
class Consumer extends Thread{
    private SynContainer container;
    
    public Consumer(SynContainer container) {
        this.container = container;
    }
    
    @Override
    public void run() {
        // 开始消费
        for (int i = 0; i < 100; i++) {
//            System.out.println("消费第"+container.pop().getid()+"号馒头");
            container.pop();
            System.out.println("消费第"+i+"个馒头");
        }
    }
}


// 缓冲区
class SynContainer{
    private int size;
    private int count = 0; // 计数器
    private Steamedbun[] buns; // 容器
 
    public SynContainer(int size) {
        this.size = size;
        this.buns = new Steamedbun[size];
    }

    // 存储 生产
    public synchronized void push(Steamedbun bun) {
        if (count>=size) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        this.notifyAll(); // 通知可以消费了
    }
    
    // 获取 消费
    public synchronized Steamedbun pop() {
        if(count==0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        this.notifyAll();  // 通知可以生产了
        return buns[count];
    }
}


// 数据（馒头等）
class Steamedbun{
    private int id;

    public Steamedbun(int id) {
        this.id = id;
    }

    public int getid() {
        return this.id;
    }
    
}


