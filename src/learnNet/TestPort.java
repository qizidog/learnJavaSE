package learnNet;

import java.net.InetSocketAddress;

/**
 * @author qizidog
 * @date 2020.05.11
 * 端口
 * 1、区分软件
 * 2、2个字节 0-65535
 * 3、同一个协议的端口不能冲突 tcp、udp
 * 4、端口定义大一点好
 */
public class TestPort {
    public static void main(String[] args) {
       // 创建方法：new InetSocketAddress(地址|域名|inetaddress对象, 端口);
       InetSocketAddress socketaddress = new InetSocketAddress("127.0.0.1", 8080);
       InetSocketAddress socketaddress2 = new InetSocketAddress("localhost", 9000);
       System.out.println(socketaddress.getHostName());
       System.out.println(socketaddress.getAddress());
       System.out.println(socketaddress2.getHostName());
       System.out.println(socketaddress2.getAddress());
       
       System.out.println("-----------------");
       System.out.println(socketaddress.getPort());
    }
}
