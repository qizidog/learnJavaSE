package learnMultiThread.basic;

/**
 * @author qizidog
 * @date 2020.04.28
 * 模拟老爸让儿子去买烟的故事
 */
public class TestJoin implements Runnable{
    public void run() {
       System.out.println(11); 
    }
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("想抽烟，发现烟没了");
            System.out.println("让儿子去买一包中华");
            Thread t = new Thread(()->{
                System.out.println("接过零钱出门");
                System.out.println("看到路边的游戏机，玩了10s");
                for(int i=0; i<10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i+"s过去了");
                }
                System.out.println("想起烟没买，赶紧买烟去");
            }, "son");
            t.start();
            
            try {
                System.out.println("等着儿子买烟.....");
                t.join();  // son线程插队，father线程被阻塞了
            } catch (InterruptedException e1) {
                System.out.println("儿子走丢了，赶紧找儿子去");
                e1.printStackTrace();
            }
            
            System.out.println("接过儿子买的烟");
            System.out.println("抽中华。。。");
            
        }, "father").start();
    }
}
