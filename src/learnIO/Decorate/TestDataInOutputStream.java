package learnIO.Decorate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 数据流（用来方便地存储java数据类型）
 * 1、先写出后读取
 * 2、读取顺序与写出顺序保持一致
 * @author qizidog
 *
 */
public class TestDataInOutputStream {
    public static void main(String[] args) throws IOException {
        outin();
        outin2();
    }
    
    // 以ByteArrayInputStream和ByteArrayOutputStream为输入输出的节点流
    public static void outin() throws IOException {
        // 写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        
        // 操作数据类型
        dos.writeUTF("编码辛酸泪，谁解其中味？");
        dos.writeInt(123);
        dos.writeDouble(123.321);
        dos.writeBoolean(true);
        dos.writeChar('q');
        dos.flush();
        byte[] datas = baos.toByteArray();  // 将xxx转为字节数组，计算xxx占用空间的大小 都可以用ByteArrayOutputStream
//        byte[] datas = os.toByteArray();  // DataOutputStream没有toByteArray方法
        System.out.println(datas.length);
        
        // 读取
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bais)); 
        String msg = dis.readUTF();
        int num = dis.readInt();
        double doub = dis.readDouble();
        boolean flag = dis.readBoolean();
        char chr = dis.readChar();
        System.out.println(msg);
        
        // ByteArrayInputStream和ByteArrayOutputStream不需要close
    }
    
    // 以FileInputStream和FileOutputStream为输入输出的节点流
    public static void outin2() throws IOException {
        // 输出
        FileOutputStream fos = new FileOutputStream(new File("src/learnIO/varible.dat"));//,true);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));
        
        dos.writeUTF("编码辛酸泪，谁解其中味？");
        dos.writeInt(123);
        dos.writeDouble(123.321);
        dos.writeBoolean(true);
        dos.writeChar('q');
        dos.flush();
        
        // 读取
        FileInputStream fis = new FileInputStream(new File("src/learnIO/varible.dat"));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(fis));
        
        String msg = dis.readUTF();
        int num = dis.readInt();
        double doub = dis.readDouble();
        boolean flag = dis.readBoolean();
        char chr = dis.readChar();
        System.out.println(msg);
        
        // 关闭
        fos.close();
        fis.close();
    }
}
