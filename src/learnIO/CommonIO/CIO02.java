package learnIO.CommonIO;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * @author qizidog
 * @date 2020.04.22
 * 利用FileUtils读取文件内容
 */
public class CIO02 {
    public static void main(String[] args) {
        // 读取文件
        try {
            String msg = FileUtils.readFileToString(new File("src/learnIO/copyedFile.txt"), "utf8");
            System.out.println(msg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // 读取文件到ByteArray
        try {
            byte[] info = FileUtils.readFileToByteArray(new File("src/learnIO/abc.txt"));
            System.out.println("length:"+info.length+"\n");
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        // 逐行读取
        try {
            List<String> list = FileUtils.readLines(new File("src/learnIO/print.txt"), "gbk");
            for (String string : list) {
                System.out.println(string);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("----------------------");
        
        // 迭代器读取
        try {
            LineIterator iter = FileUtils.lineIterator(new File("src/learnIO/print.txt"), "gbk");
            while(iter.hasNext()) {
                System.out.println(iter.nextLine());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
