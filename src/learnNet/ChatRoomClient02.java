package learnNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoomClient02 {
    public static void main(String[] args) throws UnknownHostException, IOException {
       Socket client = new Socket("localhost", 8888);
//       System.out.println("client启动");
       new Thread(new Send(client)).start();
       new Thread(new Receive(client)).start();
    }
    
    
}

class Send implements Runnable{
    private Socket client;
    private String name = "";
    private boolean isrunning = false; 
    private BufferedReader console;
    private DataOutputStream dos;
    
    public Send(Socket client) {
        this.client = client;
        this.console = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入用户名:");
            this.name = console.readLine();
            System.out.println("欢迎您加入聊天室！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            send(name);  // 构造好输出流之后，立马发送自己的用户名
        } catch (IOException e) {
            release();
        }
        isrunning = true;
    }
    
    public String getInfoRromConsole() {
        String data = "";
        try {
            data = console.readLine();
        } catch (IOException e) {
            release();
            System.out.println("====1====");
        }
        return data;
    }

    public void send(String data) {
        try {
            if (!data.equals(null)) {
                this.dos.writeUTF(data);
                dos.flush();
            }
        } catch (IOException e) {
            release();
            System.out.println("====2====");
        }
    }
    
    public void release() {
        this.isrunning = false;
        ChatUtil.close(console, dos);

    }
    
    @Override
    public void run() {
        String datas = "";
        while (isrunning){
            // 获得控制台的输入信息
            datas = getInfoRromConsole();
            send(datas);
        }
        release();
    }
}

class Receive implements Runnable{
    private Socket client;
    private boolean isrunning = false; 
    private DataInputStream dis; 
    
    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        } catch (IOException e) {
            release();
            System.out.println("++++1++++");
        }
        isrunning = true;
    }

    public String receive() {
        String data = "";
        try {
            data = dis.readUTF();
        } catch (IOException e) {
            release();
            System.out.println("++++2++++");
        }
        return data;
    }
    
    public void release() {
        ChatUtil.close(dis);
        isrunning = false;
    }
    
    @Override
    public void run() {
        while(isrunning) {
            String data = "";
            data = receive();
            System.out.println(data);
        }
        release();
    }
}

class ChatUtil{
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            try {
             target.close();
            } catch (IOException e) {

            }
        } 
     }
}
