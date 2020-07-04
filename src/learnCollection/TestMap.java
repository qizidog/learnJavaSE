package learnCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试hashmap
 * @author qizidog
 * 常用的map包括hashmap(效率高)，treemap(是有序的，自动字典排序)和hashtable(线程安全)
 */
public class TestMap {
	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1() {
		Map<Integer, String> m1 = new HashMap<>();
		
		m1.put(1, "one");
		m1.put(2, "twe");
		m1.put(3, "three");
		m1.put(4, "four");
		
		System.out.println(m1.get(4));
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(3));
		System.out.println(m1.containsValue("qizi"));
		
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		m2.put(9, "nine");
		m2.put(8, "eight");
		m2.putAll(m1);
		m2.put(4, "四");  // 覆盖
		System.out.println(m2);
	}
	
	public static void test2() {
		
		Employee e1 = new Employee(1001, "qizi", 100);
		Employee e2 = new Employee(1002, "gaoqi", 10000);
		Employee e3 = new Employee(1003, "Employeeloyee3", 10);
		
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		map.put(1001, e1);
		map.put(1002, e2);
		map.put(1003, e3);
		
		System.out.println(map.get(1001).getEname());
		
	}
}

class Employee{
	private int id;
	private String ename;
	private double salary;
	
	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}	
	
}
