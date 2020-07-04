package learnDynamicJava;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author qizidog
 * @date 2020.05.22
 * 反射处理 泛型：参数、返回值
 */
public class ReflectDemo04 {
    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("Demo04.test01()");
    }
    
    public Map<Integer, User> test02(){
        System.out.println("Demo04.test02()");
        return null;
    }
    
    public static void main(String[] args) throws Exception{
        // 获得指定方法 参数 泛型信息
        Method m = ReflectDemo04.class.getMethod("test01", Map.class, List.class);
        Type[] t = m.getGenericParameterTypes();
        for(Type paramType : t) {
            System.out.println("#"+paramType);
            if(paramType instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("泛型类型："+genericType);
                }
            }
        }
        
        System.out.println("----------");
        
        Method m2 = ReflectDemo04.class.getMethod("test02", null);
        Type returnType = m2.getGenericReturnType();
        System.out.println("#"+returnType);
        if(returnType instanceof ParameterizedType) {
            Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for(Type genericType : genericTypes) {
                System.out.println("返回值，泛型类型："+genericType);
            }
        }
    }
}
