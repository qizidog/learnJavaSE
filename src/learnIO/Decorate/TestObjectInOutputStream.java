package learnIO.Decorate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
/**
 * 不是所有的对象都可以序列化，必须要实现serializable接口
 * @author qizidog
 *
 */
public class TestObjectInOutputStream {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        outin();
        outin2();
    }
    
    public static void outin() throws FileNotFoundException, IOException, ClassNotFoundException {
        // 序列化(持久化)
        ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
        ObjectOutputStream oos = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                bytearray));
        oos.writeUTF("编码辛酸泪");
        oos.writeInt(123);
        oos.writeDouble(123.321);
        oos.writeBoolean(true);
        oos.writeChar('q');
        oos.writeObject("谁解其中味");
        oos.writeObject(new Date());
        Siri siri = new Siri("siri", 200);
        oos.writeObject(siri);
        oos.flush();
        byte[] datas = bytearray.toByteArray();
        // bytearray不需要关闭流，其他流记得要关闭！
        
        
        // 反序列化
        ObjectInputStream ois = 
                new ObjectInputStream(
                        new BufferedInputStream(
                                new ByteArrayInputStream(datas)));
        String msg = ois.readUTF();
        int num = ois.readInt();
        double doub = ois.readDouble();
        boolean flag = ois.readBoolean();
        char chr = ois.readChar();
        System.out.println(msg);
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object sir = ois.readObject();
        // bytearray不需要关闭流，其他流记得要关闭！
        
        // object转型
        if (str instanceof String) {
            String strobj = (String) str; 
            System.out.println(strobj);
        }
        if (date instanceof Date) {
            Date dateobj = (Date) date; 
            System.out.println(dateobj);
        }
        if (sir instanceof Siri) {
            Siri sirobj = (Siri) sir; 
            System.out.println(sirobj.getName()+"->"+sirobj.getPrice());
        }
    }

    
    public static void outin2() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("src/learnIO/Object.dat");
        ObjectOutputStream oos = 
                new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(file)));
        oos.writeUTF("编码辛酸泪");
        oos.writeInt(123);
        oos.writeDouble(123.321);
        oos.writeBoolean(true);
        oos.writeChar('q');
        oos.writeObject("谁解其中味");
        oos.writeObject(new Date());
        Siri siri = new Siri("siri", 200);
        oos.writeObject(siri);
        oos.flush();
        oos.close();  // 记得要关闭流！
        
        
        ObjectInputStream ois = 
                new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)));
        String msg = ois.readUTF();
        int num = ois.readInt();
        double doub = ois.readDouble();
        boolean flag = ois.readBoolean();
        char chr = ois.readChar();
        System.out.println(msg);
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object sir = ois.readObject();
        ois.close();  // 记得要关闭流！
        
        if (str instanceof String) {
            String strobj = (String) str; 
            System.out.println(strobj);
        }
        if (date instanceof Date) {
            Date dateobj = (Date) date; 
            System.out.println(dateobj);
        }
        if (sir instanceof Siri) {
            Siri sirobj = (Siri) sir; 
            System.out.println(sirobj.getName()+"->"+sirobj.getPrice());
        }
        
    }
}

class Siri implements Serializable{
    private String name;
    private transient int price; // transient关键字使得该属性不被序列化（反序列化后呈现默认值）
    
    public Siri() {
        
    }
    
    public Siri(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
