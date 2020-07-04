package GOF23.prototype;

import java.util.Date;

/**
 * @author qizidog
 * @date 2020.05.28
 * 原型模式
 */
public class Sheep implements Cloneable{
    private String name;
    private Date birthday;
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        
        // 添加以下代码实现深拷贝
        Sheep s = (Sheep) obj;  // 这里注意，强制转型之后，s和obj其实指向的是同一个对象
        s.birthday = (Date) this.birthday.clone();  // 把属性也进行拷贝
        System.out.println("obj="+obj);
        System.out.println("sheep="+s);
        System.out.println(obj==s);
        System.out.println("---------------------------------");
        
        return obj;  // 深拷贝时返回obj没问题，返回s也是一样的
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Sheep() {
        
    }
}
