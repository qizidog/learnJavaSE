package GOF23.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author qizidog
 * @date 2020.05.26
 * 测试懒汉式单例模式
 * 线程不安全，需要synchronized，调用效率相对饿汉式低
 * 如果只是加载了这个类，没有实际使用，则不会生成了类的实例（当实例化一个类时资源开销较大时推荐）
 */
public class SingletonDemo02 implements Serializable{
    // 加上volatile比较好，保证线程安全
    private static volatile SingletonDemo02 instance;  // 加载类时不立即实例化
    
    private SingletonDemo02() {
        if(instance!=null) {  // 加上这几行，防止通过反射破解单例模式
            throw new RuntimeException("非法创建对象");
        }else {
            instance = this;
        }
    }
    
    // synchronized避免多线程时new多个对象，调用效率低
    public synchronized static SingletonDemo02 getInstance() {
        if(instance==null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
    
    private Object readResolve() throws ObjectStreamException{
        return instance;  // 指定，当反序列化时，如果对象已经被实例化过了，则返回已经实例化后的对象，而非重新创建
    }
}
