package learnCollection;

/**常用的map包括hashmap(效率高)，treemap(是有序的，自动字典排序)和hashtable(线程安全)
 * 测试treemap
 */
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	
	static void test1() {
		Map<Integer, String> treemap1 = new TreeMap<Integer, String>();
		treemap1.put(20, "aa");
		treemap1.put(2, "dd");
		treemap1.put(6, "cc");
		
		for(Integer key:treemap1.keySet()) {
			System.out.println(key+":"+treemap1.get(key));
		}
	}
	
	
	static void test2() {
		Map<Emp, String> treemap2 = new TreeMap<Emp, String>();
		treemap2.put(new Emp(12, "asd", 1000), "aa");
		treemap2.put(new Emp(41, "qwe", 3000), "bb");
		treemap2.put(new Emp(15, "zxc", 200), "aa");
		
		for(Emp key:treemap2.keySet()) {
			System.out.println(key+":"+treemap2.get(key));
		}
	}
}

class Emp implements Comparable<Emp>{
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


	@Override
	public int compareTo(Emp o) {
		if(this.salary>o.salary) {
			return 1;
		}else if (this.salary<o.salary) {
			return -1;
		}else {
			if(this.id>o.id) {
				return 1;
			}else if (this.id<o.id) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	
}




