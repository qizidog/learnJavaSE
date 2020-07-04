package WriteServer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qizidog
 * @date 2020.05.18
 * 针对
 * <servlet-mapping>
 * <servlet-name>login</servlet-name>
 * <url-pattern>/login</url-pattern>
 * <url-pattern>/g</url-pattern>
 * </servlet-mapping>
 */
public class Mapping {
    private String name;  // servlet-name
    private Set<String> patterns;  // url-pattern
    
    public Mapping() {
        patterns = new HashSet<String>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void addPattern(String pattern) {
        this.patterns.add(pattern);
    }

    
    
}
