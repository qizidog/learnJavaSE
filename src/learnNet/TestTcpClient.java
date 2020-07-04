package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qizidog
 * @date 2020.05.14
 * 创建服务器
 * 1、使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、关闭释放资源
 */
public class TestTcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("this is client.");
        // 1、使用Socket创建客户端+服务器的地址和端口
        Socket client = new Socket("localhost", 8888);
        
        // 2、操作：输入输出流操作
//        opt01(client);  // 文字对话交流
        opt02(client);  // 文件上传
    }

    public static void opt01(Socket client) throws IOException {
        // 输出
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名:");
        String uname = br.readLine();
        System.out.println("请输入密码:");
        String upasswd = br.readLine();

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname:"+uname+"&"+"upasswd:"+upasswd);
        dos.flush();
        // 输入
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String ret = dis.readUTF();
        System.out.println(ret);
        
        // 3、关闭释放资源
        dos.close();
        client.close();
    }
    
    public static void opt02(Socket client) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("image/net.png"));
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        int len = -1;
        byte[] flush = new byte[1024];
        System.out.println("开始上传文件...");
        while((len=bis.read(flush))!=-1) {
            bos.write(flush, 0, len);
        }
        bos.close();
        bis.close();
        client.close();
    }
}
