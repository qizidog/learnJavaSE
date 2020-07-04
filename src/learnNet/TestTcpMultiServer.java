package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

public class TestTcpMultiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("----------服务器启动----------");
        ServerSocket server = new ServerSocket(8888);
        Socket client = null;
        boolean isrunning = true;
        while(isrunning) {
            client = server.accept();
            new Thread(new Channel(client)).start();
            System.out.println("一个客户建立连接");
        }
        server.close();
    }
    
    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        public Channel(Socket client) {
            this.client = client;
            init();
        }
        
        private void init() {
            try {
                dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }
        
        @Override
        public void run() {
            String msg = receive();
            
            String[] msgArray = msg.split("&");
            String uname = "";
            String upasswd = "";
            for (String string : msgArray) {
                String[] info = string.split(":");
                if(info[0].equals("uname")){
                    uname = info[1];
                    System.out.println("用户名-->"+uname);
                } else if (info[0].equals("upasswd")) {
                    upasswd = info[1];
                    System.out.println("账号-->："+upasswd);
                }
            }
            if(uname.equals("qizidog")&&upasswd.equals("123456")) {
                msg = "登陆成功";
            }else {
                msg = "用户名或密码错误";
            }
            
            response(msg);
            
            release();  // 最后统一释放资源

        }
        
        public String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            } 
            return msg;
        };
        
        public void response(String msg) {
            try {
                System.out.println(msg);
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            } 
        }
        
        public void release() {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
