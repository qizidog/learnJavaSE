package WriteServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author qizidog
 * @date 2020.05.17
 * 熟悉使用sax解析xml文件的流程
 */
public class WebSax {
    public static void main(String[] args) throws Exception {
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
                getResourceAsStream("WriteServer/web.xml"), handler);
        
        
        // 输出查看解析的结果
        List<Entity> entities = handler.getEntities();
//        for (Entity entity : entities) {
//            System.out.println("servlet="+entity.getName()+"-->"+entity.getClz());
//        }
//        
        List<Mapping> mappings = handler.getMappings();
//        for (Mapping mapping : mappings) {
//            System.out.println("servlet-mapping="+mapping.getName()+"-->"+mapping.getPatterns());
//        }
        
        // 获取数据（假设你输入了/login）
        System.out.println();
        WebContext context = new WebContext(entities, mappings);
        String className = context.getClz("/login");  // 通过webcontext映射class
        System.out.println(className);
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        servlet.service();
    }
}

class WebHandler extends DefaultHandler{
    private ArrayList<Entity> entities;
    private ArrayList<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag;  // 存储正在操作的标签
    private boolean isMapping = false;
    
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Mapping> getMappings() {
        return mappings;
    }

    @Override
    // startDocument 和 endDocument 其实可以不要，里面的内容写到声明或者构造器的位置就可以了
    public void startDocument() throws SAXException{ 
        System.out.println("----解析文档开始----");
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("解析element开始:"+qName);
        if (qName!=null) {
            tag = qName;
            if(qName.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            }else if (qName.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if(contents.length()>0) {
            if (tag.equals("servlet-name")) {
                if(isMapping) {
                    mapping.setName(contents);
                }else {
                    entity.setName(contents);
                }
            } else if (tag.equals("servlet-class")) {
                entity.setClz(contents);
            } else if (tag.equals("url-pattern")) {
                mapping.addPattern(contents);
            }
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("解析element结束:"+qName);
        if(qName.equals("servlet")) {
            entities.add(entity);
        }else if(qName.equals("servlet-mapping")) {
            mappings.add(mapping);
        }
//        tag = null;
    }
    
    @Override
    // startDocument 和 endDocument 其实可以不要，里面的内容写到声明或者构造器的位置就可以了
    public void endDocument() throws SAXException {
        System.out.println("----解析文档结束----");
    }
}
