package learnIO.CommonIO;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * @author qizidog
 * @date 2020.04.22
 * 利用FileUtils拷贝文件
 */
public class CIO04 {
    public static void main(String[] args) {
        try {
            // 复制文件
            FileUtils.copyFile(new File("image/ball.png"), new File("src/learnIO/copyball.png"));
            
            // 复制文件到目录
            FileUtils.copyFileToDirectory(new File("image/ball.png"), new File("src/learnIO"));
//            FileUtils.copyToDirectory(src, destDir);  // 此方法自动判定被复制对象为文件或目录

            // 复制目录
//            FileUtils.copyDirectory(srcDir, destDir); // 将src内的文件拷贝到dest中
//            FileUtils.copyDirectoryToDirectory(srcDir, destDir); // 将dest作为src的子目录拷贝
            
            // 复制URL到文件(不知道怎么弄不下来)
//            URL url = new URL("http://my.swjtu.edu.cn/coremail/s?func=lp:getImg&img_id=logo_001&org_id=");
//            FileUtils.copyURLToFile(url, new File("src/learnIO/sxt.png"));
            
            // 下载URL源码
            String datas = IOUtils.toString(new URL("http://www.baidu.com"), "utf8");
            System.out.println(datas);
            datas = IOUtils.toString(new URL("http://www.163.com"), "gbk");
            System.out.println(datas);
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        
    }
}
