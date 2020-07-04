package GOF23.prototype;

import java.util.Date;

/**
 * @author qizidog
 * @date 2020.05.28
 * 原型模式（当使用new新建对象非常耗时时，通过原型模式生成新的对象是一个不错的选择）
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Date date = new Date(124324124421L);
        
        Sheep s1 = new Sheep("少利", date);
        System.out.println(s1);
        System.out.println(s1.getName()+" "+s1.getBirthday());
        System.out.println("---------------------------------");
        
        // 浅拷贝：多利和少利的birthday都指向同一个date，当
        Sheep s2 = (Sheep) s1.clone();
        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName()+" "+s2.getBirthday());
        System.out.println("---------------------------------");
        
        // 修改了少利的生日，但多利的生日也被改编
        s1.getBirthday().setDate(1221332464);
        System.out.println(s1.getName()+" "+s1.getBirthday());
        System.out.println(s2.getName()+" "+s2.getBirthday());
        
        // 通过修改被拷贝对象的clone方法可以实现深拷贝
        // 或者通过序列化和反序列化也可以实现深拷贝（个人感觉更方便一些，先序列化到bytearray中，再反序列化回来）
    }
}
