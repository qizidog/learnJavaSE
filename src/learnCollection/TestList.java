package learnCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * 测试list和set
 * @author qizidog
 * 常用的list包括arraylist(底层是数组)，linkedlist(底层是链表)和vector(线程安全)
 */
public class TestList {
	public static void main(String[] args) {
//		test01();
//		test02();
		test03();
	}
	
	public static void test01() {
		Collection<String> c = new ArrayList<String>();
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		c.add("qizigou");
		c.add("douglas");
		c.add("qizidog");
		c.add("qizi");
		c.add("秋&龙卷");
		c.remove("qizigou");
//		c.clear();
		
		Object[] objs = c.toArray();
		System.out.println(objs.toString());
		
		System.out.println(c.size());
		System.out.println(c);
		System.out.println(c.contains("qizidog"));
	}
	
	public static void test02() {
		List<String> list1 = new ArrayList<String>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		List<String> list2 = new ArrayList<String>();
		list2.add("cc");
		list2.add("dd");
		list2.add("ee");
		
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		
//		list1.addAll(list2);  // 取并集
//		list1.removeAll(list2);  // 从list1中删除所有list2和list1的交集
		list1.retainAll(list2);  // 取交集
		System.out.println(list1.containsAll(list2));  // 判断list1中是否包含list2中所有的元素
		System.out.println("list1:"+list1);
		
		
		
	}

	public static void test03() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("G");
		
		System.out.println(list);
		
		list.add(3, "D");
		list.set(4, "F");
		System.out.println(list);
		System.out.println(list.get(2));
		
		list.add("B");
		System.out.println(list.indexOf("D"));
		System.out.println(list.lastIndexOf("B"));
	}
}
