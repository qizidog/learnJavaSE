package learnMultiThread.coop;

/**
 * @author qizidog
 * @date 2020.05.07
 * 单例模式DCL：在多线程环境下，对外只存在一个对象
 * 1、构造器私有化，避免外部new对象
 * 2、提供私有的静态属性：存储对象的地址
 * 3、提供公共的静态方法：获取属性
 */

public class DoubleCheckedLocking {
    // 私有的静态属性
    private static volatile DoubleCheckedLocking instance;  // volatile解决指令重排问题
    // 没有volatile，其他线程可能访问到一个没有完成初始化的空对象 
    
    // 构造器私有化
    private DoubleCheckedLocking() {
        
    }
    
    // 公共的静态方法
    public static DoubleCheckedLocking getInstance() {
        if (instance!=null) {  // 双重检测
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (instance==null) {
                instance = new DoubleCheckedLocking();
                // 1、开辟空间    2、初始化对象信息    3、返回对象的地址给引用
                // 如果第2步很耗时间，可能会有指令重排，3先于2返回了地址，但地址对应的对象是个空对象，此时在多线程状态下容易出错
            }
        }
        return instance;
    }
    
    public static void main(String[] args) {
        // 得到的都是相同的地址
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();
        new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        }).start();
    }
}
