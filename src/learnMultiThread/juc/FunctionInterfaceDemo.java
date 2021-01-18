package learnMultiThread.juc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author : qizidog
 * @date : 2021-01-18 13:31
 * @description :
 * 学习 四大函数式接口 和 流式计算
 **/

public class FunctionInterfaceDemo {

    // java.util.function包下全是函数式接口
    // 四大函数式接口：Function, Predicate, Supplier, Consumer
    // 其余接口均是以上四大基本接口的变种
    public static void main(String[] args) {
        learn();

        System.out.println("===================");

        practise();
    }

    public static void learn(){
        String cst = "hello";

        Function<String, String> func = (str)->{return str+", world";};
        System.out.println(func.apply(cst));

        Predicate<String> pre = (str)->{return str.isEmpty();};
        System.out.println(pre.test(cst));

        Supplier<String> sup = ()->{return "qizidog";};
        System.out.println(sup.get());

        Consumer<String> con = (str)->{ System.out.println(str+", qizidog"); };
        con.accept(cst);
    }

    /**
     * lambda表达式，函数式接口，链式编程，stream流式计算
     * 现有5个用户，按以下条件筛选
     * 1. ID必须是偶数
     * 2. 年龄必须大于23岁
     * 3. 用户名转为大写字母
     * 4. 用户名字倒着排序
     * 5. 只输出一个用户
     */
    public static void practise(){
        User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        // Stream流
        list.stream()
                .filter((u)->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map((u)->{u.setName(u.getName().toUpperCase());return u;})
                .sorted((uu1, uu2)->{return uu2.getName().compareTo(uu1.getName());})
                .limit(1)
                .forEach(System.out::println);
    }

}

class User{
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
