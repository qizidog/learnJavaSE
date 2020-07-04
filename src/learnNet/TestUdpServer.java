package learnNet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author qizidog
 * @date 2020.05.12
 * 接收端
 * 1、使用DatagramSocket，指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket)
 * 4、分析数据
 *   byte[] getData()
 *          getLength()
 * 5、释放资源
 */
public class TestUdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动中......");
//        * 1、使用DatagramSocket，指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(27880); // 这个端口必须和client请求的端口一致
//        * 2、准备容器，封装成DatagramPacket包裹
        byte[] container = new byte[1024*60]; // 最多60k
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
//        * 3、阻塞式接收包裹receive(DatagramPacket)
        server.receive(packet);
//        * 4、分析数据
//        byte[] datas = packet.getData();
//        int len = packet.getLength();
//        System.out.println(new String(datas, 0, len, "utf8"));
        System.out.println(new String(container, "utf8")); // 其实数据已经写到container里面了，没必要再建一个数组
//        * 5、释放资源
        server.close();
    }
}
