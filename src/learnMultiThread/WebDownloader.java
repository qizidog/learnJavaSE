package learnMultiThread;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class WebDownloader {
    public static void main(String[] args) {
        
    }
    
    public static void download(String url_s, String path) {
        try {
            URL url = new URL(url_s);
            FileUtils.copyURLToFile(url, new File(path));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("不合法的url");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
