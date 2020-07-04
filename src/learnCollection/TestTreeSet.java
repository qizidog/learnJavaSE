package learnCollection;

import java.util.Set;
import java.util.TreeSet;
/**
 * 测试treeset(treeset是有序的，自动字典排序，底层是treemap)
 * @author qizidog
 * treeset若使用自定义的class作为元素，则该自定义的class必须实现Comparable接口的compareTo方法
 * treemap同理
 */
public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(300);
		set.add(400);
		set.add(100);
		
		System.out.println(set);
		
		test();
	}
	
	static void test(){
		TreeSet<AA> aa = new TreeSet<AA>();
		aa.add(new AA(123));
		aa.add(new AA(234));
		aa.add(new AA(745));
		
		System.out.println(aa);
	}
}

class AA implements Comparable<AA>{
	private int a;
	
	
	public AA(int a) {
		super();
		this.a = a;
	}

	@Override
	public String toString() {
		return ""+a;
	}
	
	@Override
	public int compareTo(AA o) {
		if(this.a>o.a) {
			return 1;
		}else if(this.a<o.a){
			return -1;
		}else {
			return 0;
		}
	}
}
