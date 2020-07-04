package WriteServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qizidog
 * @date 2020.05.19
 * 1、使用ServerSocket建立与浏览器的连接，获取请求协议
 * 2、实现对客户端的响应，并封装响应信息（内容动态添加，关注状态码）
 * 3、封装请求信息
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    
    // 启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            this.isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
            stop();
        }
    }
    
    // 接受连接 服务
    public void receive() {
        Socket client;
        while(isRunning) {
            try {
                client = serverSocket.accept();
                System.out.println("一个客户端建立了连接");
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                System.out.println("客户端错误");
                e.printStackTrace();
            }
        }
    }
    
    // 停止服务
    public void stop() {
        this.isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
