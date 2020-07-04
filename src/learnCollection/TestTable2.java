package learnCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用javabean对象存储，多行数据放到容器里面
 * @author qizidog
 *
 */
public class TestTable2 {
	public static void main(String[] args) {
		User usr1 = new User(1001, "张三", 20000, "2018.5.5");
		User usr2= new User(1002, "李四", 30000, "2005.4.4");
		User usr3 = new User(1003, "张三", 10000, "2020.3.3");
		User usr4 = new User(1004, "张三", 8000, "2014.3.15");
		
		List<User> usrlist = new ArrayList<User>();
		usrlist.add(usr1);
		usrlist.add(usr2);
		usrlist.add(usr3);

		for (User user : usrlist) {
			System.out.println(user);
		}
	}
}

// 一个完整的javabean，要有set和get方法，以及一个无参数的构造器
class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;

	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + ", hiredate=" + hiredate + "]";
	}

	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
}
