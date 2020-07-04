package learnCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 常用的set包括hashset(底层是hashmap)和treeset(底层是treemap)
 * treeset是有序的，自动使用字典排序组织
 * @author qizidog
 * 测试hashset(hashset是无序的)
 */
public class TestSet {
	public static void main(String[] args) {
		test1();
	}
	
	static void test1() {
		Set<String> set1 = new HashSet<String>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("cc");
		set1.add("aa");
		set1.remove("dd");  // 没有的话不报错
		System.out.println(set1);
		
		Set<String> set2 = new HashSet<String>();
		set2.add("qizi");
		set2.addAll(set1);
		System.out.println(set2);
	}
}
