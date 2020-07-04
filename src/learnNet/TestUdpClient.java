package learnNet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author qizidog
 * @date 2020.05.12
 * 发送端
 * 1、使用DatagramSocket创建发送端
 * 2、准备数据，转成字节数组
 * 3、封装成DatagramPacket，需要指定目的地
 * 4、发送包裹 send(DatagramPacket p)
 * 5、释放资源
 */
public class TestUdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中......");
//        * 1、使用DatagramSocket创建发送端
        DatagramSocket client = new DatagramSocket(18181);
//        * 2、准备数据，转成字节数组
        String data = "qizidog的java学习之旅";
        byte[] datas = data.getBytes("utf8");
//        * 3、封装成DatagramPacket，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 27880)); // 这个端口必须和server的端口一致
//        * 4、发送包裹 send(DatagramPacket p)
        client.send(packet);
//        * 5、释放资源
        client.close();
    }
}
