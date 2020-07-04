package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.04
 * 测试volatile
 * volatile被称为轻量版的synchronized，它只保证数据的同步
 */
public class TestVolatile {
//    private static int num = 0;  // 如果直接运行，程序并不会在1s后停止运行，因为cpu一直繁忙，没有更改num的值
    private volatile static int num = 0;  // 加上volatile之后，num的如果变更，系统会通知立刻读取新的值，这样程序才能结束
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(num==0) {  // 此处不要写代码，目的是让cpu始终处于繁忙状态
                
            }
        }).start();
        
        Thread.sleep(1000);
        num = 1;
    }
}
