package WriteServer.server;

/**
 * @author qizidog
 * @date 2020.05.20
 * 服务器小脚本接口
 */
public interface Servlet {
    void service(Request request, Response response);
//    void doGet(Request request, Response response);
//    void doPost(Request request, Response response);
}
