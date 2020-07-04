package GOF23.singleton;

/**
 * @author qizidog
 * @date 2020.05.26
 * 静态内部类单例模式
 * 兼顾线程安全、延时加载、调用效率高三大优势
 */
public class SingletonDemo04 {
    private static class SingletonClassInstance{  // 类加载的过程是绝对线程安全的
        private static /*final*/ SingletonDemo04 instance = new SingletonDemo04();
    }
    
    private SingletonDemo04() {
        
    }
    
    public static SingletonDemo04 getInstance() {
        // 内部类在实际使用时才会被加载，而不是在外部类加载时一并加载
        return SingletonClassInstance.instance;
    }
}
