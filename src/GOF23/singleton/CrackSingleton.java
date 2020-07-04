package GOF23.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;


/**
 * @author qizidog
 * @date 2020.05.27
 * 通锟斤拷锟斤拷锟斤拷头锟斤拷锟斤拷谢锟斤拷平獾ワ拷锟侥Ｊ�(锟斤拷锟斤拷锟斤拷式为锟斤拷Demo02)
 */
public class CrackSingleton {
    public static void main(String[] args) throws Exception {
//        SingletonDemo02 s1 = SingletonDemo02.getInstance();
//        SingletonDemo02 s2 = SingletonDemo02.getInstance();
//        System.out.println(s1);
//        System.out.println(s2);
        
//        test01();
        test02();
    }
    
    public static void test01() throws Exception{
        // 锟斤拷锟斤拷锟斤拷锟�
        Class<SingletonDemo02> clz = (Class<SingletonDemo02>) Class.forName("GOF23.singleton.SingletonDemo02");
        Constructor<SingletonDemo02> c = clz.getDeclaredConstructor(null);  // 锟斤拷锟斤拷薏喂锟斤拷锟斤拷锟�
        c.setAccessible(true);
        SingletonDemo02 sn1 = c.newInstance(null);
        SingletonDemo02 sn2 = c.newInstance(null);
        System.out.println("锟狡斤拷玫锟斤拷亩锟斤拷锟�"+sn1);
        System.out.println("锟狡斤拷玫锟斤拷亩锟斤拷锟�"+sn2);
    }
    
    public static void test02() throws Exception {
        // 锟斤拷锟斤拷锟叫伙拷锟斤拷锟斤拷
        SingletonDemo02 s1 = SingletonDemo02.getInstance();
        System.out.println(s1);
        String path = "src/GOF23/singleton/serialized.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(s1);  // 锟斤拷锟叫伙拷
        oos.close();
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        SingletonDemo02 s2 = (SingletonDemo02) ois.readObject();
        System.out.println(s2);
    }
}
