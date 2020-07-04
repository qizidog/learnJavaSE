package learnCollection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 使用HashSet和TreeSet存储多个商品信息，遍历并输出;
 * 其中商品属性：编号，名称，单价，出版社;要求向其中添加多个相同的商品，验证集合中元素的唯一性。
 * @author qizidog
 *
 */
public class Homework02 {
	static Book book1 = new Book(1001, "learn python", 30, "lkjdf");
	static Book book2 = new Book(1002, "learn java", 35, "ngfhdf");
	static Book book3 = new Book(1003, "learn c++", 20, "jkdfgf");
	static Book book4 = new Book(1004, "learn c#", 19, "asdf");

	public static void main(String[] args) {
//		hashset();
		treeset();
	}
	
	static void hashset() {
		HashSet<Book> book_set = new HashSet<Book>();
		book_set.add(book1);
		book_set.add(book2);
		book_set.add(book3);
		book_set.add(book4);
		book_set.add(book1);
		
		System.out.println("print by foreach");
		for (Book book : book_set) {
			System.out.println(book);
		}
		
		System.out.println("print by iterator");
		for(Iterator<Book> iter=book_set.iterator(); iter.hasNext();) {
			Book temp = iter.next();
			System.out.println(temp);
		}
	}
	
	static void treeset() {
		TreeSet<Book> treeset = new TreeSet<Book>();
		treeset.add(book1);
		treeset.add(book2);
		treeset.add(book3);
		treeset.add(book4);
		
		System.out.println("print by foreach");
		for (Book temp:treeset) {
			System.out.println(temp);
		}
		
		System.out.println("print by iterator");
		for (Iterator<Book> iter=treeset.iterator(); iter.hasNext();) {
			Book temp = iter.next();
			System.out.println(temp);
		}
	}
	
}
