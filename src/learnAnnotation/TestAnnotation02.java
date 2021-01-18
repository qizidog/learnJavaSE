package learnAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 * @author qizidog
 * @date 2020.05.23
 * 使用反射获得注解信息
 */
public class TestAnnotation02 {
    public static void main(String[] args) {
        // 通过反射读取注解信息，模拟处理注解信息的流程
        try {
            Class claz = Class.forName("learnAnnotation.Student");
            
            // 获得类的所有有效注解
            Annotation[] annotations = claz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            
            // 获得类的指定的注解
            MyTableAnnotation ta = (MyTableAnnotation) claz.getAnnotation(MyTableAnnotation.class);
            System.out.println("ta.value():"+ta.value());
            
            // 获得类的属性的注解
            Field f = claz.getDeclaredField("name");
            MyFieldAnnotation fa = f.getAnnotation(MyFieldAnnotation.class);
            System.out.println(fa.columnName()+"--"+fa.type()+"--"+fa.length());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}


@MyTableAnnotation("tb_student")
class Student{
    @MyFieldAnnotation(columnName = "idd", type = "int", length = 10)
    private int id;
    @MyFieldAnnotation(columnName = "named", type = "varchar", length = 10)
    private String name;
    @MyFieldAnnotation(columnName = "aged", type = "int", length = 3)
    private int age;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
