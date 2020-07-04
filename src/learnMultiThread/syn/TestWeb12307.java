package learnMultiThread.syn;


public class TestWeb12307{
    public static void main(String[] args) {
        Web12307 web = new Web12307(20, "12307");
        new Passenger(web, "qizi", 3).start();
        new Passenger(web, "hayu", 2).start();
    }
}

class Passenger extends Thread{ // 继承Thread类用来做代理
    int sets;
    public Passenger(Runnable target, String name, int sets) {
        super(target, name);  // 父类的构造器
        this.sets = sets;  // 新增的属性
    }
}

class Web12307 implements Runnable{
    private int available;
    String name;
    
    public Web12307(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public  void run() {  // 直接锁这里不会乱序
        Passenger p = (Passenger)Thread.currentThread();
        boolean flag = bookTickets(p.sets);
        if(flag) {
            System.out.println(Thread.currentThread().getName()+"订票成功，剩余票数："+this.available);
        }else {
            System.out.println(Thread.currentThread().getName()+"订票失败，余票不足");
        }
        
    }
    
    private synchronized boolean bookTickets(int sets) { // 经百方验证，锁这里会出点问题
        
        try {  // 如果锁这个方法，则需要延时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
        if(available>=sets) {
            available -= sets; 
//            System.out.println(sets);
            return true;
        }
        return false;
    }
    
}
