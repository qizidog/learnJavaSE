package learnNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author qizidog
 * @date 2020.05.11
 * inetaddress
 * ip地址和主机名
 */
public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机inetaddress对象 及 相关信息
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        System.out.println("---------------");
        
        // 根据域名的到inetaddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        System.out.println("---------------");

        // 根据IP得到inetaddress对象
        addr = InetAddress.getByName("60.255.151.8");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());  // 输出ip而不是域名（ip地址不存在，或者dns服务器不允许进行ip地址和域名的映射）
        System.out.println("---------------");
    }
}
