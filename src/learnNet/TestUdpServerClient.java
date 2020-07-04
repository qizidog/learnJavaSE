package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author qizidog
 * @date 2020.05.12
 * 自己利用多线程实现UDP协议发送和接收Object类型的数据
 */
public class TestUdpServerClient {
    public static void main(String[] args) {
//        communicate01();
//        communicate02();
        communicate03();
    }

    public static void communicate01() {
        new Thread(()->{
                    UdpServer server = new UdpServer(19980);
        //            server.receiveByteArray();
                    server.receiveObject();
        //            System.out.println("String:"+new String(server.getContainer()));
                }).start();
                
        new Thread(()->{
                    String msg = "qizidog的java学习之旅";
        //            boolean flag = true;
                    UdpClient client = new UdpClient(59518);
        //            client.sendByteArray(msg.getBytes());
                    client.sendObject(msg, new InetSocketAddress("localhost", 19980));
        //            client.sendObject(flag);
                }).start();
    }
    
    public static void communicate02() {
        new Thread(()->{
            byte[] datas = "qizidog的java学习之旅02".getBytes();
            UdpConnection port1 = new UdpConnection(19980, 19518);
//            port1.setToport(29518);
//            port1.sendByteArray(datas);
            port1.sendByteArray(datas, new InetSocketAddress("localhost", 29518));
            
        }).start();
        
        new Thread(()->{
            UdpConnection port2 = new UdpConnection(29980, 29518, 19518);// 发送用的端口，接收用的端口
            byte[] msg = port2.receiveByteArray();
            System.out.println(new String(msg));
            
        }).start();
    }
    
    public static void communicate03() {
        new Thread(new UdpConnection(19980, 19518, 29518), "qizidog").start();
        new Thread(new UdpConnection(29980, 29518, 19518), "hayu").start();
    }
}



class UdpClient{
    private DatagramSocket client = null;  // 发送端
    private InetSocketAddress addr;  // 发往哪里去
    private DatagramPacket packet = null;
    
    public UdpClient(int port) {
        try {
            this.client = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    
    public void sendByteArray(byte[] datas, InetSocketAddress addr) {
        this.addr = addr;
        this.packet = new DatagramPacket(datas, 0, datas.length, this.addr);
        try {
            this.client.send(packet);
        } catch (IOException e) {
            System.out.println("发送失败!");
            e.printStackTrace();
        }
    }
    
    public void sendObject(Object obj, InetSocketAddress addr) {
        // 流处理
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        byte[] datas = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(baos));
            oos.writeObject(obj);
            oos.flush();
            datas = baos.toByteArray();  // 转换字节数组
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // 打包发送
        this.sendByteArray(datas, addr);
    }
}


class UdpServer{
    private DatagramSocket server = null;  // 接收端
    private byte[] container = new byte[1024*60];
    private DatagramPacket packet = null;

    public UdpServer(int port) {
        try {
            this.server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.packet = new DatagramPacket(container, container.length);
    }
    
    public void receiveByteArray() {
        try {
            this.server.receive(this.packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // datas已经写入到container里面了
    }
    
    public void receiveObject() {
        receiveByteArray();
        ObjectInputStream ois = null;
        Object datas;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(container);
            ois = new ObjectInputStream(new BufferedInputStream(bis));
            datas = ois.readObject();
            System.out.println(datas);  // 输出接收到的数据
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] getContainer() {
        return container;
    }

}

class UdpConnection implements Runnable{
    private DatagramSocket sendport;
    private DatagramSocket receiveport;
//    private DatagramPacket packet;
    private InetSocketAddress toport;
    private byte[] container = new byte[1024*60];
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String name = null;
    
    public UdpConnection(int sendport, int receiveport) {
        try {
            this.sendport  = new DatagramSocket(sendport);
            this.receiveport = new DatagramSocket(receiveport);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
    }
    
    public UdpConnection(int sendport, int receiveport, int toport) {
        try {
            this.sendport  = new DatagramSocket(sendport);
            this.receiveport = new DatagramSocket(receiveport);
            this.toport = new InetSocketAddress("localhost", toport);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
    }
    
    public void setToport(int toport) {
        this.toport = new InetSocketAddress("localhost", toport);
    }
    
    public void sendByteArray(byte[] datas, InetSocketAddress addr) {
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, addr);
        try {
            this.sendport.send(packet);
        } catch (IOException e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
    
    public void sendByteArray(byte[] datas) {
        // packet自己建，不要搞成fields
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(datas, 0, datas.length, this.toport);
        } catch (IllegalArgumentException e) {
            System.out.println("未设置toport，toport为null");
        }
        try {
            this.sendport.send(packet);
        } catch (IOException e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
    
    public byte[] receiveByteArray() {
//        byte[] container = new byte[1024*60];  // container是不是fields都影响不大
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        try {
            this.receiveport.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int len = packet.getLength();
        byte[] datas = new byte[len];
        for (int i=0; i<len; i++) {
            datas[i] = container[i];
        }
        return datas;// 不要直接用container
    }
    
    @Override
    public void run() {
        this.name = Thread.currentThread().getName();
        // 用于发送数据的子线程
        new Thread(()->{
            String data = null;
            byte[] datas;
            while(true) {
                try {
                    data = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                datas = data.getBytes();
                this.sendByteArray(datas); // 发送数据
                if(data.equals("bye")) {
                    break;
                }
            }
            this.sendport.close();
            System.out.println(this.name + "终止send聊天");
        }).start();
        
        
        // 用于接收数据的子线程
        new Thread(()->{
            byte[] datas = null;
            String data;
           while(true) {
               datas = this.receiveByteArray(); // 接收数据
               data = new String(datas);
               System.out.println(this.name + " receive: " + data);
               if(data.equals("bye")) {
                   break;
               }
           }
           this.receiveport.close();
           System.out.println(this.name + "终止receive聊天");
        }).start();
        
    }
}
