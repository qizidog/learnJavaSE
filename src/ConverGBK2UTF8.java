import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.*;
import java.util.Collection;

/**
 * @author : qizidog
 * @date : 2020-06-17 22:38
 * @description :
 *     将指定目录下的所有java文件由GBK编码转换为UTF-8编码
 **/

public class ConverGBK2UTF8 {

    private static BufferedReader br = null;
    private static BufferedWriter bw = null;


    public static void main(String[] args) {

        doConvert("./src/");

    }

    public static void doConvert(String path2convert, String sCharset, String dCharset){

        Collection<File> col = getFileList(path2convert);
        Object[] arr = col.toArray();
        File src;      // 源文件
        File dest;     // 目标文件

        for (Object f : arr) {
            src = (File) f;
            dest = getSavePath(src);

            boolean flag = true;  // 默认路径存在
            if (!dest.getParentFile().exists()) {  // 如果目标文件路径不存在
                flag = dest.getParentFile().mkdirs();  // 创建路径
            }

            if (flag) {
                ConverChatsetByIO(src, dest, sCharset, dCharset);
            } else {
                System.out.println(dest + "转码失败");
            }
        }
        System.out.println("转码完成");
    }


    public static void doConvert(String path2convert) {
        doConvert(path2convert, "gbk", "utf-8");
    }


    // 获得待处理文件路径集
    public static Collection<File> getFileList(String path2convert){
        return FileUtils.listFiles(new File(path2convert),
//                FileFilterUtils.and(new SuffixFileFilter(".java"), EmptyFileFilter.NOT_EMPTY),
                new SuffixFileFilter(".java"),
                DirectoryFileFilter.INSTANCE);
    }


    // 根据原文件路径生成新的文件路径
    private static File getSavePath(File srcPath){
        String parent = srcPath.getPath();
        return new File(".\\src2"+parent.substring(5));
    }


    private static void ConverChatsetByIO(File src, File dest, String sCharset, String dCharset){

        String text;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(src), sCharset));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), dCharset));
            while ((text = br.readLine()) != null) {
                String ret = new String(text.getBytes(dCharset), dCharset);
                bw.write(ret);
                bw.newLine();
                bw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放流
            close(br, bw);
        }
    }

    private static void close(Closeable... ios) {  // 可变参数
        for (Closeable io:ios) {
            if(io!=null) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
