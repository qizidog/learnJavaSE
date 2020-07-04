package WriteServer;

import java.lang.reflect.InvocationTargetException;

/**
 * @author qizidog
 * @date 2020.05.17
 * 反射：把java类中各种结构（方法、属性、构造器、类名）映射成一个个的java对象
 * 1、获取Class对象（三种方式）
 *   1.1 对象.getClass()
 *   1.2 类.class()
 *   1.3 Class.forName("包名.类名")
 * 2、动态创建对象
 * 
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // 获取Class对象（三种方式）
        Class cls = getcls();
        
        // 创建对象
        createcls(cls);
        
    }
    
    public static Class getcls() throws ClassNotFoundException {
        // 1.1 对象.getClass() 
        Iphone iphone = new Iphone();
        Class cls = iphone.getClass();  // 引用的可以
        cls = new Iphone().getClass();  // 直接创建的也可以
        
        // 1.2 类.class()
        cls = Iphone.class;
        
        // 1.3 Class.forName("包名.类名")  推荐此方法
        cls = Class.forName("WriteServer.Iphone");
        
        return cls;
    }
    
    public static void createcls(Class cls) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // 2.1 newInstance方法
        Iphone iphone = (Iphone)cls.newInstance();  // newInstance方法在jdk1.9中被弃用（不推荐了）
        System.out.println(iphone);
        
        // 2.2 使用构造器
        iphone = (Iphone)cls.getConstructor().newInstance();
        System.out.println(iphone);
        
    }
}

class Iphone{
    public Iphone() {
    }
}
