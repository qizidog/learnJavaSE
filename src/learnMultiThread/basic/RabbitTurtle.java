package learnMultiThread.basic;

public class RabbitTurtle implements Runnable{
    private int total = 20;
    private int step;
    private String winner;
    
    public RabbitTurtle(int step) {
        this.step = step;
    }

    public RabbitTurtle() {
    }
    
    public void run() {
        while(true) {
            if(gameover()) {  // 是否终止
                break;
            }else {
                if(Thread.currentThread().getName().equals("rabbit") && this.total%3==0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.total-=this.step;
                System.out.println(this.total);
            }
        }
    }
    
    private boolean gameover() {
        if(winner!=null) {
            return true;
        }else {
            if(total<0) {
                winner = Thread.currentThread().getName();
                System.out.println("The winner is " + winner);
                return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        RabbitTurtle rt = new RabbitTurtle(2);
        Thread th1 = new Thread(rt, "rabbit");
        Thread th2 = new Thread(rt, "turtle");
        th1.start();
        th2.start();
    }
}
