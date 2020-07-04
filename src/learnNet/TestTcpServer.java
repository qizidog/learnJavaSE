package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qizidog
 * @date 2020.05.14
 * 创建服务器
 * 1、使用ServerSocket创建服务器
* 2、阻塞式等待连接accept
 * 3、操作：IO输入输出流
 * 4、关闭释放资源
 */
public class TestTcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("this is server");
        // 1、使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        
        // 2、阻塞式等待连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        
        // 3、操作：IO输入输出流
//        opt01(server, client);  // 文字对话交流
        opt02(server, client);  // 接收上传文件
    }

    public static void opt01(ServerSocket server, Socket client) throws IOException {
        DataInputStream dis = new DataInputStream(client.getInputStream());
        // 输入 处理一下
        String data = dis.readUTF();
        String uname = "";
        String upasswd = "";
        String[] dataArray = data.split("&");
        for (String string : dataArray) {
            String[] info = string.split(":");
            if(info[0].equals("uname")) {
                System.out.println("输入的用户名是-->"+info[1]);
                uname = info[1];
            } else if(info[0].equals("upasswd")) {
                System.out.println("输入的密码是-->"+info[1]);
                upasswd = info[1];
            }
        }
        // 输出
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if(uname.equals("qizidog")&&upasswd.equals("123456")) {
            dos.writeUTF("登录成功！");
        }else {
            dos.writeUTF("用户名不存在或密码输入错误！");
        }
        
        // 4、关闭释放资源
        dis.close();
        client.close();
        server.close();  // 服务器一般不关闭，24h服务
    }
    
    public static void opt02(ServerSocket server, Socket client) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\qizidog\\Desktop\\net.png"));
        int len = -1; 
        byte[] flush = new byte[1024];
        while((len=bis.read(flush))!=-1) {
            bos.write(flush, 0, len);
        }
        System.out.println("接收文件成功："+new File("C:\\Users\\qizidog\\Desktop").exists());
        bis.close();
        client.close();
        server.close();
    }
}
