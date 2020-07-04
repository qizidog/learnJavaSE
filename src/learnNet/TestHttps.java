package learnNet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author qizidog
 * @date 2020.05.13
 * java里面似乎不能直接访问https的网址
 * 之前io流下载网络图片的时候就遇到过
 * 这里简单测试并配置一下，尝试通过配置使得能够访问https的网页
 */
public class TestHttps {
    public static void main(String[] args) throws Exception {
//        getHttp();
        getHttps();
    }

    public static void getHttp() throws Exception {
        int len;
        char[] flush = new char[1024];
        String msg = "";
        URL url = new URL("https://www.baidu.com");
        InputStreamReader isr = new InputStreamReader(url.openStream(), "utf8");
//        while((len=isr.read(flush))!=-1) {
//            System.out.print(flush);
//        }
        BufferedReader br = new BufferedReader(isr);
        while((msg = br.readLine())!=null) {
            System.out.print(msg);
        }
        br.close();
    }
    
    public static void getHttps() throws Exception{
        URL url = new URL("https://www.jd.com");
//        URL url = new URL("https://www.dianping.com/");
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");//设置请求方式
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.100 Mobile Safari/537.36");
        
        String msg = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf8"));
        while((msg=br.readLine())!=null) {
            System.out.println(msg);
        }
        br.close();
    }
}
