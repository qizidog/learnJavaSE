package WriteServer.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qizidog
 * @date 2020.05.20
 * 实现runnable接口的类，用来分发调度服务器ServerSocket接收到的多个请求
 */
public class Dispatcher implements Runnable{
    private Socket client;
    private Request request;
    private Response response;
    
    public Dispatcher(Socket client) {
        this.client = client;
        try {
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            release();
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        // 获取请求协议
        try {
//        打印一些信息用来观察
//        System.out.println(request.getMethod()+"-->"
//                +request.getUri()+"-->"
//                +request.getQueryStr());
//        for(String temp:request.getParameterValues("fav")) {
//            System.out.println(temp);
//        }
            
//        手动new新的对象
//        Servlet servlet;
//        if(request.getUri().equals("login")) {
//            servlet = new LoginServlet();  // 启动登录服务
//            servlet.service(request, response);
//        } else if(request.getUri().equals("reg")) {
//            servlet = new RegisterServlet();  // 启动注册服务
//            servlet.service(request, response);
//        } 
            
            if(request.getUri()==null || request.getUri().equals("")) {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("WriteServer/server/index.html");
                byte[] flush = new byte[1024*50];
                int len = -1;
                len = is.read(flush);
                response.print(new String(flush, 0, len, "utf8"));
                response.pushToBrowser(200);  // 返回响应协议
                is.close();
                return;
            }
            // 根据uri反射配置文件得到servlet服务（更加灵活）
            Servlet servlet = WebApp.getServletFromUrl(request.getUri());
//            System.out.println(request.getUri());
            if(null!=servlet) {
                servlet.service(request, response);
                response.pushToBrowser(200);  // 返回响应协议
            }else {
                // 错误页面
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("WriteServer/server/error.html");
                byte[] flush = new byte[1024*50];
                int len = -1;
                len = is.read(flush);
                response.print(new String(flush, 0, len, "utf8"));
                response.pushToBrowser(404);  // 返回响应协议
                is.close();
            }
          
        } catch (IOException e) {
            try {
                response.pushToBrowser(505);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        release();
    }
    
    // 释放资源
    private void release() {
        try {
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
