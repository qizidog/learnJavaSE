package learnCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 使用List和Map存放多个图书信息，遍历并输出。
 * 其中商品属性：编号，名称，单价，出版社;使用商品编号作为Map中的key。
 * @author qizidog
 *
 */
public class Homework01 {
	public static void main(String[] args) {
//		list_mthd();
		map_mthd();
	}
	
	static void list_mthd() {
		List<Book> list = new ArrayList<>();
		list.add(new Book(1001, "learn python", 30, "lkjdf"));
		list.add(new Book(1002, "learn java", 35, "ngfhdf"));
		list.add(new Book(1003, "learn c++", 20, "jkdfgf"));
		list.add(new Book(1004, "learn c#", 19, "asdf"));
		
		Collections.sort(list);
		
		// print by for each
		System.out.println("print by for each");
		for (Book book : list) {
			System.out.println(book);
		}
		
		// print by iterator
		System.out.println("print by iterator");
		for(Iterator<Book> iter=list.iterator();iter.hasNext();) {
			Book temp = iter.next();
			System.out.println(temp);
		}
	}
	
	static void map_mthd() {
		Map<Integer, Book> map = new HashMap<Integer, Book>();
		map.put(1001, new Book(1001, "learn python", 30, "lkjdf"));
		map.put(1002, new Book(1002, "learn java", 35, "ngfhdf"));
		map.put(1003, new Book(1003, "learn c++", 20, "jkdfgf"));
		map.put(1004, new Book(1004, "learn c#", 19, "asdf"));
		
		System.out.println("print by foreach");
		for (Integer temp : map.keySet()) {
			System.out.println(temp+":"+map.get(temp));
		}
		
		System.out.println("print by iterator");
		Set<Entry<Integer, Book>> entry_set = map.entrySet();
		for (Iterator s = entry_set.iterator(); s.hasNext();) {
			Entry<Integer, Book> entry = (Entry<Integer, Book>) s.next();
			System.out.println(entry);
		}
	}
}

class Book implements Comparable<Book>{
	private int id;
	private String name;
	private int price;
	private String publish;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, int price, String publish) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.publish = publish;
	}
	
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		if(this.price>o.price) {
			return 1;
		}else if(this.price<o.price){
			return -1;
		}else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", price=" + price + ", publish=" + publish;
	}
	
}
