package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoomClient01 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // 1、创建客户端
        Socket client = new Socket("localhost", 8888);
        
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        client.getOutputStream()));
        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        client.getInputStream()));
        
        boolean isrunning = true;
        while(isrunning) {
            // 2、客户端发送消息
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            
            // 3、客户端获取消息
            msg = dis.readUTF();
            System.out.println(msg);
        }
        
        dos.close();
        dis.close();
        client.close();
    }
}
