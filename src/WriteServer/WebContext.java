package WriteServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qizidog
 * @date 2020.05.20
 * 通过servlet-mapping映射servlet的servlet-class
 */
public class WebContext {
    private List<Entity> entities;
    private List<Mapping> mappings;
    // key-->servlet-name, value-->servlet-class
     Map<String, String> entitymap = new HashMap<String, String>();
    // key-->url-pattern, value-->servlet-name
     Map<String, String> mappingmap = new HashMap<String, String>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;
        
        for (Entity entity : entities) {
            entitymap.put(entity.getName(), entity.getClz());
        }

        for (Mapping mapping : mappings) {
            for (String pattern: mapping.getPatterns()) {
                mappingmap.put(pattern, mapping.getName());
            }
        }
    }
    
    public String getClz(String pattern) {
        
        return entitymap.get(mappingmap.get(pattern));
    }
    
}
