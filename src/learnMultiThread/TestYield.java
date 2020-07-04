package learnMultiThread;

public class TestYield {
    public static void main(String[] args) {
//       MyYield my = new MyYield();
//       new Thread(my, "thread 01").start();
//       new Thread(my, "thread 02").start();
        
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda..."+i);
            }
        }).start();
        
        for(int i=0; i<100; i++) {
            if(i%2==0) {
                Thread.yield(); // main礼让
            }
            System.out.println("main..."+i);
        }
    }
    
    
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println("start: "+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("stop: "+Thread.currentThread().getName());
    }
    
}
