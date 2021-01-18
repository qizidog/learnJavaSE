package learnAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qizidog
 * @date 2020.05.21
 * 元注解：负责注解其他注解，只有4个：Target, Retention, Documented, Inherited
 * Target: 描述注解的使用范围
 * Retention: 描述注解的生命周期(source, class, runtime)    runtime时可以被反射机制读取
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {  // 如果注解只有一个参数的话，通常定义为value
    String studentName() default "";  // 参数类型 参数名() default xxx    默认值可以不写，则必须要传参数
    int age();
    int id() default -1;
    String[] schools() default {"清华大学", "尚学堂"};
}
