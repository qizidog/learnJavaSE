package GOF23.singleton;

/**
 * @author qizidog
 * @date 2020.05.26
 * 测试饿汉式单例模式
 * 线程安全（类加载时是天然线程安全的），调用效率高
 * 如果只是加载了这个类，没有实际使用，其实也生成了类的实例（不必要）
 */
public class SingletonDemo01 {
    // 类初始化时立即加载
    private static SingletonDemo01 instance = new SingletonDemo01();
    
    private SingletonDemo01() {
        
    }
    
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}
