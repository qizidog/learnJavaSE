package WriteServer.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Date;

/**
 * @author qizidog
 * @date 2020.05.20
 * 封装响应：只关注具体内容，其他工作由内部完成
 */
public class Response {
    private BufferedWriter bw;
    private StringBuilder content;  // 正文
    private StringBuilder headInfo;  // 头信息（状态行、响应头）
    private int len;  // 正文的字节数
    private final String SPACE = " ";
    private final String CRLF = "\r\n";
    
    private Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    
    public Response(Socket client){
        this();
        try {
            this.bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "utf8"));
        } catch (IOException e) {
            headInfo = null;
            e.printStackTrace();
        }
    }
    
    public Response(OutputStream os){
        this();
        this.bw = new BufferedWriter(new OutputStreamWriter(os));
    }
    
    private void createHeadInfo(int code) {  // code 状态码(关注200；404；505等)
        // 1、状态行：HTTP/1.1 200 OK
        headInfo.append("HTTP/1.1").append(SPACE);
        headInfo.append(code).append(SPACE);
        String mark = "";
        switch (code) {
            case 200:
                mark = "OK";
                break;
            case 404:
                mark = "PAGE NOT FOUND";
                break;
            case 505:
                mark = "SERVER ERROR";
            default:
                break;
        }
        headInfo.append(mark).append(CRLF);
        
     // 2、响应头：多行（最后一行是空行）
        /*
         * Data:xxxxxx
         * Server:shsxt Server/0.0.1;charset=GBK
         * Content-type:text/html
         * Content-length:xxxxx
         */
        headInfo.append("DATE:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(this.len).append(CRLF);
        headInfo.append(CRLF);
    }
    
    public Response print(String info) {  // 添加正文信息
        content.append(info);
        try {
            len+=info.getBytes("utf8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Response println(String info) {
        content.append(info+CRLF);
        try {
            len+=(info+CRLF).getBytes("utf8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public void pushToBrowser(int code) throws IOException {
        if(null==headInfo) {
            code = 505;
        }
        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }
}
