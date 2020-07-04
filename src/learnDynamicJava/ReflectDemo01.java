package learnDynamicJava;

/**
 * @author qizidog
 * @date 2020.05.22
 * Class类相当于模板/设计图纸，相同类的Class对象相同
 * 获取Class对象的方法有3种
 * 1.Class.forName()
 * 2.classname.class
 * 3.instance.getClass()
 */
@SuppressWarnings("all")
public class ReflectDemo01 {
    public static void main(String[] args) {
        String path = "learnDynamicJava.User";
        
        try {
            Class clazz = Class.forName(path);
            System.out.println(clazz.hashCode());
            System.out.println(clazz);
            
            
            Class clz1 = int.class;
            Class clz2 = double[].class;
            double[] db = {3.14, 2.73};
            Class clz3 = db.getClass();
            Class clz4 = void.class;
            Class clz5 = clazz.getClass();
            
            System.out.println(clz1.hashCode());
            System.out.println(clz2.hashCode());
            System.out.println(clz3.hashCode());
            System.out.println(clz4.hashCode());
            System.out.println(clz5.hashCode());
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
