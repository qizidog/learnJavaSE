package learnDynamicJava;

/**
 * @author qizidog
 * @date 2020.05.22
 * 应用反射的API， 获取 类的信息（类的名字、属性、方法、构造器等）
 * 
 */
@SuppressWarnings("all")
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        String path = "learnDynamicJava.User";
        try {
            Class clzz = Class.forName(path);
            
            // 获取类的名字
            System.out.println(clzz.getName());  // 获得全路径（包名+类名）
            System.out.println(clzz.getSimpleName());  // 获得类名

            // 获得类的属性
            System.out.println("-------------------");
            System.out.println(clzz.getField("uname"));  // 获得指定的属性（必须是public）
            System.out.println(clzz.getFields().length);  // 直接获得所有的public属性
            System.out.println(clzz.getDeclaredField("name"));  // 获得指定的属性（任意修饰符的都可以）
            System.out.println(clzz.getDeclaredFields().length);  // 直接获得所有的属性
            
            // 获得类的方法
            System.out.println("-------------------");
            System.out.println(clzz.getMethod("getName", null));
            System.out.println(clzz.getMethod("setName", String.class));
            System.out.println(clzz.getMethods().length);  // 所有public方法，包括了从父类和接口继承的方法
            System.out.println(clzz.getDeclaredMethod("setUname", String.class, double.class));
            System.out.println(clzz.getDeclaredMethods().length);  // 所有方法，不包括从父类和接口继承来的
            
            // 获得类的构造器
            System.out.println("-------------------");
            System.out.println(clzz.getConstructor(null));  // 获得指定的public构造器
            System.out.println(clzz.getConstructors().length);  // 获得所有的共有构造器
            System.out.println(clzz.getDeclaredConstructor(String.class, int.class, int.class));
            System.out.println(clzz.getDeclaredConstructors().length);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
