package learnIO.Decorate;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TestPrintStream {
    public static void main(String[] args) {
        print();
    }
    
    public static void print() {
        PrintStream ps = System.out; // System.out其实就是一个声明好的PrintStream对象
        ps.println("qizi");  // 输出到控制台
        
        try {
            ps = new PrintStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/learnIO/print.txt")), true);// 自动刷新
            ps.println("测试PrintStream"); // 打印到了print.txt里面
            ps.println("我是qizidog");
//            ps.flush();  // 若自动刷新，则不需要这个
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        // 重定向文件输出端
        System.out.println("控制台");
        System.setOut(ps);
        System.out.println();
        System.out.println("重定向到print.txt");
        
        // 关闭流
        if (ps!=null) {
            ps.close();
        }
        
        // 重定向回到控制台
        System.setOut(new PrintStream(
                new BufferedOutputStream(
                new FileOutputStream(
                        FileDescriptor.out)), true));  // 自动刷新
        System.out.println("回到控制台");
    }
}
