package learnCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试泛型
 * @author qizidog
 *
 */
public class TestGenerics {
	public static void main(String[] args) {
		MyCollection<String> mc = new MyCollection<String>();
		mc.set("qizi", 0);
		mc.set("dog", 1);
		mc.set("douglas", 2);
		mc.set("qi", 3);
		mc.set("2020", 4);
		
		String a = mc.get(4);
		String b = mc.get(0);
		System.out.println(a+b);
	}
	
	public void listtest() {
		List<String> list = new ArrayList<String>();
		Map map = new HashMap();
	}
}


class MyCollection<E>{ // 常用E、T、V三个字母
	Object[] objs = new Object[5];
	
	public void set(E e, int index) {
		objs[index] = e;
	}
	
	public E get(int index) {
		return (E) objs[index];
	}
}
