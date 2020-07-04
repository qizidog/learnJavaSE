package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatRoomServer01 {
    public static void main(String[] args) throws IOException {
        // 1、创建服务端并建立连接
        ServerSocket server = new ServerSocket(8888);
        
        while(true) {
            Socket client = server.accept();
            System.out.println("----------一个客户建立连接----------");
            
            new Thread(()->{
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(
                            new BufferedInputStream(
                                    client.getInputStream()));
                    dos = new DataOutputStream(
                            new BufferedOutputStream(
                                    client.getOutputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                boolean isrunning = true;
                while(isrunning) {
                    String datas;
                    try {
                        // 2、服务端接收消息
                        datas = dis.readUTF();
                        // 3、服务端发送消息
                        dos.writeUTF(datas);
                        dos.flush();
                    } catch (IOException e) {
                        isrunning = false;
//                        e.printStackTrace();
                    }
                    
                }
                
                // 释放资源
                try {
                    if(dos!=null) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                try {
                    if(dos!=null) {
                        dis.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
