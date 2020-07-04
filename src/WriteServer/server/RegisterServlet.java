package WriteServer.server;

public class RegisterServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
//        System.out.println("register servlet");
        response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
        response.print("注册成功");
    }

}
