package learnAnnotation;

/**
 * @author qizidog
 * @date 2020.05.23
 * 使用注解
 */
@MyAnnotation01(studentName = "zhangsan", age = 1)
public class TestAnnotation01 {
    @MyAnnotation01(age = 18)
    public static void main(String[] args) {
        String[] temp = {"aljf", "jgls"};
        System.out.println(temp[0]+temp[1]);
    }
}
