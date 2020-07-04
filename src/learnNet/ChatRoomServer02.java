package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatRoomServer02 {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
    public static void main(String[] args) throws IOException {
        // 1、创建服务端并建立连接
        ServerSocket server = new ServerSocket(8888);
        System.out.println("------服务器启动------");
        
        while(true) {
            Socket client = server.accept();
            
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
            System.out.println("----------一个客户建立连接----------");
        }
    }
    
    static class Channel implements Runnable{
        private Socket client = null;
        private String name = "";
        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private boolean isrunning = false;
        
        public Channel(Socket client) {
            this.client = client;
            try {
                this.dis = new DataInputStream(
                                new BufferedInputStream(
                                        client.getInputStream()));
                this.dos = new DataOutputStream(
                        new BufferedOutputStream(
                                client.getOutputStream()));
                this.isrunning = true;
                this.name = receive();  // 接收用户名
                sendOthers(this.name+"加入了聊天", true);
            } catch (IOException e) {
                release();
            }
        }
        
        @Override
        public void run() {
            while(isrunning) {
                String datas;
                // 2、服务端接收消息
                datas = receive();
                // 3、服务端发送消息
                sendOthers(datas, false);
            }
//            release();
        }
        
        // 接收
        public String receive() {
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                System.out.println("---1---");
                release();
            }
            return datas;
        }
        
        // 发送
        public void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("---2---");
                release();
            }
        }
        
        public void sendOthers(String msg, boolean isSys) {
                if (!msg.equals("")&&!msg.equals(null)) {
                    // 约定私聊格式  @xxx：msg
                    boolean isPrivate = msg.startsWith("@");
                    if(isPrivate) {
                        int idx = msg.indexOf(":");
                        String targetName = msg.substring(1, idx);
                        msg = msg.substring(idx+1);
                        for (Channel target : all) {
                            if(target.name.equals(targetName)) {
                                target.send(this.name+"私聊你: "+msg);
                                break;
                            }
                        }
                    }else {
                        for (Channel other : all) {
                            if(other==this) {
                                continue;
                            }
                            if(!isSys) {
                                other.send(this.name+": "+msg);  // 加上信息发送者的用户名
                            }else {
                                other.send("----"+msg+"----");
                            }
                        }
                    }
                }
            }
        
        // 释放
        public void release() {
            isrunning = false;
            ChatUtil.close(dis, dos, client);
            all.remove(this);
            sendOthers(this.name+"离开了群聊", true);
        }
    }
    
}


