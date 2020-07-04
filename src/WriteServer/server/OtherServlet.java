package WriteServer.server;

public class OtherServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
//        System.out.println("other servlet");
        response.print("其他页面");
    }

}
