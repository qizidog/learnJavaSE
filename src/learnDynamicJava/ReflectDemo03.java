package learnDynamicJava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qizidog
 * @date 2020.05.23
 * 使用反射 操作 类的构造方法、普通方法。属性
 */
public class ReflectDemo03 {
    public static void main(String[] args) {
        String path = "learnDynamicJava.User";
        try {
            Class<User> clz = (Class<User>) Class.forName(path);
            
            // 通过反射API动态调用构造方法，构造对象
            User user = clz.newInstance();  // 直接调用无参构造器
            user = clz.getConstructor(null).newInstance();  // 调用可以传参数的构造器
            user = clz.getDeclaredConstructor(String.class, int.class, int.class).newInstance("xiaoming", 18, 1001);
            System.out.println(user);
            
            // 通过反射API调用普通方法
            User u2 = clz.newInstance();
            // 下面两行相当于u2.setName("qizidog");  好处是动态调用，程序之间解耦，调用的方法可通过配置文件或者浏览器传入
            Method mth = clz.getMethod("setName", String.class);
            mth.invoke(u2, "qizidog");
            System.out.println(u2.getName());
            
            // 通过反射API操作属性
            Field f = clz.getDeclaredField("name");
            // 反射的效率约为正常调用的1/30，为了提高反射的效率，可以考虑禁止安全监测
            f.setAccessible(true);  // 这个属性不做安全检查了，可以直接访问
            f.set(u2, "douglas_qi");
            System.out.println(u2.getName());  // 这两种方法都可以
            System.out.println(f.get(u2));
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
