package WriteServer.server;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import WriteServer.server.Entity;
import WriteServer.server.Mapping;

/**
 * @author qizidog
 * @date 2020.05.20
 * 处理器，由WebApp调用，解析xml文件
 */
public class WebHandler extends DefaultHandler{
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
//        System.out.println("----解析文档开始----");
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
//        System.out.println("----解析文档结束----");
    }
}
