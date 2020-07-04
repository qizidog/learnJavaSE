package learnMultiThread.coop;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        // timer类本身就是一个线程
        // timertask是一个抽象类，已经实现了runnable接口
        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 1000);  // 延迟1s开始执行
//        timer.schedule(new MyTask(), 1000, 5000);  // 延时1s开始执行，间隔5s执行一次，不会自动停止
        Calendar cal = new GregorianCalendar(2020,Calendar.MAY,3,23,18);
        timer.schedule(new MyTask(), cal.getTime(), 2000);  // 指定时间执行,2s执行一次
    }
}

class MyTask extends TimerTask{
    @Override
    public void run() {
       for(int i=0; i<7; i++) {
           System.out.println("放空大脑休息一会儿"+i);
       }
       System.out.println("---------end---------");
    }
    
}
