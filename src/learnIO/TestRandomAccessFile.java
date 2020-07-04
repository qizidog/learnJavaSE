package learnIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author qizidog
 *
 */
public class TestRandomAccessFile {

    public static void main(String[] args) throws IOException {
//        access();
//        access2();
        access3();
    }

    public static void access() throws IOException {
        RandomAccessFile randf = new RandomAccessFile(new File("src/learnIO/print.txt"), "r");
        randf.seek(9); // 指定起始位置，读取剩余全部内容
        
        byte[] flush = new byte[1024];
        int len=-1;
        while((len=randf.read(flush))!=-1) {
            System.out.println(new String(flush, 0, len));
        }
        randf.close();  // 切记关闭流
    }
    
    public static void access2() throws IOException {
        // 读取指定区块的内容
        RandomAccessFile randf = new RandomAccessFile(new File("src/learnIO/print.txt"), "r");
        int begin = 2;
        int actualSize = 22;
        randf.seek(begin); // 指定起始位置，读取剩余全部内容
        
        byte[] flush = new byte[12];
        int len=-1;
        while((len=randf.read(flush))!=-1) {
            if(actualSize>len) {
                System.out.println(new String(flush, 0, len));
                actualSize -= len;
            } else {
                System.out.println(new String(flush, 0, actualSize));
                break;
            }
        }
        randf.close();  // 切记关闭流
    }
    
    public static void access3() throws IOException {
        // 分块读取
        File file = new File("src/learnIO/print.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int blockSize = 20;  // 块大小
        
        // 起始位置和实际大小
        int beginPos = 5;
        int len = -1;
        byte[] flush = new byte[blockSize];
        int i=0;
        raf.seek(beginPos);
        while((len=raf.read(flush))!=-1) {
            System.out.println(i+"-->"+(i*blockSize+beginPos)+"-->"+(i*blockSize+beginPos+len));
//            System.out.println(new String(flush, 0, len));
            i++;
        }
        raf.close();
    }
}
