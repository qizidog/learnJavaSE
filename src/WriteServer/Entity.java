package WriteServer;

/**
 * @author qizidog
 * @date 2020.05.18
 * 针对
 * <servlet>
 * <servlet-name>login</servlet-name>
 * <servlet-class>com.shsxt.LoginServlet</servlet-class>
 * </servlet>
 */
public class Entity {
    private String name;  // servlet-name
    private String clz;  // servlet-class
    
    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
    
    
}
