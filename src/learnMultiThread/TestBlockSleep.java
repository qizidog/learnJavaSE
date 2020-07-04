package learnMultiThread;

import java.util.Date;

/**
 * @author qizidog
 * @date 2020.04.27
 * 倒计时
 */
public class TestBlockSleep {
    public static void main(String[] args) throws InterruptedException {
        countdown();
    }
    
    public static void countdown() throws InterruptedException {
        int num = 10;
        long cur = System.currentTimeMillis();
        Date endTime = new Date(cur+1000*10);
        while (true) {
            System.out.println(endTime);
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if(endTime.getTime()<cur) {
                break;
            }
            
        }
        
    }
}
