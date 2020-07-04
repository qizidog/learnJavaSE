package WriteServer.server;

import java.io.IOException;

/**
 * @author qizidog
 * @date 2020.05.19
 * 目标
 */
public class LoginServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
//        System.out.println("login servlet");
        // 响应内容：只关注具体内容
        response.print("<html>");
        response.print("<head>");
        response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
        response.print("<title>");
        response.print("服务器响应成功:loginServlet");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("欢迎回来，"+request.getParameterValue("uname")+"("+request.getParameterValue("sex")+")");
        response.print("</body>");
        response.print("</html>");
        
    }

}
