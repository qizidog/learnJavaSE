package learnMultiThread.syn;

import java.util.ArrayList;
import java.util.List;

public class TestMovie {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=8; i++) {
            list.add(Integer.valueOf(i));
        }
        Cinema c = new Cinema(list);
        
        // 顾客1需要的位置
        List<Integer> set1 = new ArrayList<Integer>();
        set1.add(1);
        set1.add(2);
        new Thread(new Customer(c, set1), "hayu").start();

        // 顾客2需要的位置
        List<Integer> set2 = new ArrayList<Integer>();
        set2.add(3);
        set2.add(4);
        set2.add(6);
        new Thread(new Customer(c, set2), "qizi").start();
        
        // 顾客3需要的位置
        List<Integer> set3 = new ArrayList<Integer>();
        set3.add(6);
        set3.add(7);
        set3.add(8);
        new Thread(new Customer(c, set3), "dog").start();
    }
}

class Cinema{
    private List<Integer> available;
    String name = "qizi cinema";
    
    public Cinema(List<Integer> available) {
        this.available = available;
    }
    
    public boolean bookTickets(List<Integer> sets) {
//        synchronized (this) {
            System.out.println("可用的位置为："+available);
            
            List<Integer> copy = new ArrayList<Integer>();
            copy.addAll(available);  // 复制一份
            
            // 相减
            copy.removeAll(sets);
            
            if(copy.size() == available.size()-sets.size()) {
                available = copy;
                return true;
            }
            return false;
//        }
    }
}

class Customer implements Runnable{
       private Cinema cinema;
       private List<Integer> sets;

    public Customer(Cinema c, List<Integer> sets) {
       this.cinema = c;
       this.sets = sets;
    }
    
    @Override
    public void run() {
       synchronized (cinema) {
       boolean flag = cinema.bookTickets(sets); 
       if(flag) {
           System.out.println("购票成功->"+Thread.currentThread().getName()+" "+this.sets);
       }else {
        System.out.println("出票失败，位置不够->"+Thread.currentThread().getName()+" "+this.sets);
       }
       }
    }
}
