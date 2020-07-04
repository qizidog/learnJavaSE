package learnCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历list、map、set
 * @author qizidog
 *
 */
public class TestIterator {
	public static void main(String[] args) {
//		testlist();
		testmap1();
		testmap2();
//		testset();
	}
	
	static void testlist() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
//		Iterator<E> iter
		for(Iterator<String> iter=list.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	
	static void testmap1() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1001, "qi");
		map.put(1002, "zi");
		map.put(1004, "dog");
		
		Set<Entry<Integer, String>> ss = map.entrySet();
		
		for(Iterator/*<Entry<Integer, String>>*/ iter=ss.iterator(); iter.hasNext();) {
			Entry/*<Integer, String>*/ temp = (Entry) iter.next();
			System.out.println(temp.getKey()+":"+temp.getValue());
		}
	}
	static void testmap2() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1001, "qi");
		map.put(1002, "zi");
		map.put(1004, "dog");
		
		Set<Integer> ss = map.keySet();
		for(Iterator<Integer> iter=ss.iterator(); iter.hasNext();) {
			Integer temp = iter.next();
			System.out.println(temp+":"+map.get(temp));
		}
	}
	static void testset() {
		Set<String> set = new HashSet<String>();
		set.add("qi");
		set.add("zi");
		set.add("dog");
		
		for(Iterator<String> iter=set.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
}
