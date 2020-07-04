package learnCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试collections工具类
 * @author qizidog
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<10; i++) {
			list.add("qizi"+i);
		}
		System.out.println(list);
		
		Collections.shuffle(list); // 随机排列list中的元素
		System.out.println(list);
		
		Collections.reverse(list); // 逆序
		System.out.println(list);
		
		Collections.sort(list); // 排序
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "qizi3")); // 二分查找
	}
	
	
}
