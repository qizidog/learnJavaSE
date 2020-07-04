package learnIO.CommonIO;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * @author qizidog
 * @date 2020.04.22
 */
public class CIO01 {
    public static void main(String[] args) {
        // 获得文件的大小
        long len = FileUtils.sizeOf(new File("src/learnIO/print.txt"));
        System.out.println(len);
        
        // 获得文件夹中文件的总大小
        len = FileUtils.sizeOf(new File("src/learnIO"));
        System.out.println(len);
        
        // 列出文件夹下的所有非空文件（不包含子目录）
        Collection<File> files = FileUtils.listFiles(new File("src/learnIO"), 
                                    EmptyFileFilter.NOT_EMPTY, null);
        for (File file : files) {
            System.out.println(file);
        }
        
        System.out.println("---------------1--------------");
        
        // 列出文件夹下的所有非空文件（子目录中的也一并列出）
        Collection<File> files2 = FileUtils.listFiles(new File("src/learnIO"),
                                    EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files2) {
            System.out.println(file);
        }
        
        System.out.println("---------------2--------------");
        
        // 列出所有非空的java文件和class文件
        Collection<File> files3 = FileUtils.listFiles(new File("src/learnIO"), 
                                   FileFilterUtils.or(new SuffixFileFilter(".java"), new SuffixFileFilter(".class")),
                                   DirectoryFileFilter.INSTANCE);
        for (File file : files3) {
            System.out.println(file);
        }
    }
}
