package GOF23.singleton;

/**
 * @author qizidog
 * @date 2020.05.26
 * 测试双检测锁式单例模式
 * 线程不安全，用synchronized做块的修饰，调用效率相对饿汉式低，但比懒汉式高，可以延时创建单例
 * 由于jvm的底层机制，存在指令重排的问题，不建议使用，偶尔可能出现问题
 */
public class SingletonDemo03 {
    private static volatile SingletonDemo03 instance;  // 加载类时不立即实例化
    
    private SingletonDemo03() {
        
    }
    
    // synchronized避免多线程时new多个对象，调用效率低
    public static SingletonDemo03 getInstance() {
        if(instance!=null) {
            return instance;
        }
        synchronized (SingletonDemo03.class) {
            if(instance!=null) {
                return instance;
            }
            instance = new SingletonDemo03();
            return instance;
        }
    }
}
