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

public class TestTcpMultiClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("----------客户端启动----------");
        Socket client = new Socket("localhost", 8888);
        new Send(client).send();
        new Receive(client).receive();
    }
    
    static class Send{
        private DataOutputStream dos;
        private BufferedReader console;
        private Socket client;
        private String msg;
        
        public Send(Socket client) {
            this.client = client;
            console = new BufferedReader(new InputStreamReader(System.in));
            String uname = ""; 
            String upasswd = "";
            try {
                System.out.println("请输入用户名：");
                uname = console.readLine();
                System.out.println("请输入密码：");
                upasswd = console.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    console.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            msg = "uname:"+uname+"&"+"upasswd:"+upasswd;
        }
        
        public void send() {
            try {
                dos = new DataOutputStream(
                        new BufferedOutputStream(
                                client.getOutputStream()));
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } /*finally {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
    
    static class Receive{
        private DataInputStream dis;
        private Socket client;
        
        public Receive(Socket client) {
            this.client = client;
        }
        
        public void receive() {
            try {
                dis = new DataInputStream(
                        new BufferedInputStream(
                                client.getInputStream()));
                String msg = dis.readUTF();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            } /*finally {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}
