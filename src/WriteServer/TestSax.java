package WriteServer;

import java.io.IOException;
import java.util.ArrayList;

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
public class TestSax {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        // SAX解析
        // 1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2、从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        // 3、编写处理器(PHandler)
        // 4、加载文档 Document 注册处理器
        PersonHandler handler = new PersonHandler();
        // 5、解析
        parse.parse(Thread.currentThread().getContextClassLoader().
                getResourceAsStream("WriteServer/person.xml"), handler);
        
    }
}

class PersonHandler extends DefaultHandler{
    private ArrayList<Person> persons;
    private Person person;
    private String tag;  // 存储正在操作的标签
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----解析文档开始----");
        persons = new ArrayList<Person>();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("解析element开始:"+qName);
        if (qName!=null) {
            tag = qName;
            if(qName.equals("person")) {
                person = new Person();
            }
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if(contents.length()>0) {
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                person.setAge(Integer.valueOf(contents));
            }
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("解析element结束:"+qName);
        if(qName.equals("person")) {
            persons.add(person);
        }
//        tag = null;
    }
    
    @Override
    public void endDocument() throws SAXException {
        System.out.println("----解析文档结束----");
        for (Person person : persons) {
            System.out.println(person.getName()+": "+person.getAge());
        }
    }
}

class Person{
    private String name;
    private int age;
    
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
