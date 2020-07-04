package WriteServer.server;

import java.net.Socket;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

//import WriteServer.WebContext;


/**
 * @author qizidog
 * @date 2020.05.20
 * 重新整理WebSax的内容
 */
public class WebApp {
    private static WebContext context;
    static {
        try {
            // SAX解析
            // 1、获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 2、从解析工厂获取解析器
            SAXParser parse = factory.newSAXParser();
            // 3、编写处理器(PHandler)
            // 4、加载文档 Document 注册处理器
            WebHandler handler = new WebHandler();
            // 5、解析
            parse.parse(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("WriteServer/server/web.xml"), handler);
            
            // context实例化
            context = new WebContext(handler.getEntities(), handler.getMappings());
            
        }catch (Exception e) {
            System.out.println("解析配置文件错误");
        }
    }
    
    public static Servlet getServletFromUrl(String uri) {  // 通过url获取获取配置文件对应的servlet
        String className = context.getClz('/'+uri);  // 通过webContext将uri映射到class
        System.out.println("class name: "+className);
        Class clz;
        try {
            clz = Class.forName(className);
            Servlet servlet = (Servlet)clz.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            return null;
//            e.printStackTrace();
        }
    }
}


















