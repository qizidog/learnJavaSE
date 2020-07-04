package learnCollection;

import java.util.HashMap;

public class MyHashSet<K> {
	HashMap<K, Object> map;
	
	private static final Object PRESENT = new Object();
	
	public MyHashSet(){
		map = new HashMap();
	}
	
	public void add(K key) {
		map.put(key, PRESENT);
	}
	
	public void remove(K key) {
		map.remove(key);
	}
	
	public int size() {
		return map.size();
	}
	
	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder("{");
//		for (K k:map.keySet()) {
//			sb.append(k+",");
//		}
//		sb.setCharAt(sb.length()-1, '}');
		
		StringBuilder sb = new StringBuilder();
		sb.append(map.keySet());
		sb.setCharAt(0, '{');
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyHashSet<String> hsmap = new MyHashSet<String>();
		
		hsmap.add("aaaa");
		hsmap.add("bbbb");
		hsmap.add("cccc");
		
		System.out.println(hsmap);
	}
	
}
