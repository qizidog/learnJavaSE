package oo.oo2;

public class TestString {
	public static void main(String[] args) {
		String a = "qizidog";
		String b = "qizidog";
		String c = new String("qizidog");
		
		System.out.println(a == b);  // 涉及到内存常量池
		System.out.println(a == c);  // String是一个对象，==在判断两个对象是否相等时，判断其id是否一致
		System.out.println(b == c);
		
		// 在比较字符串时，通常使用equals
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(b.equals(c));
		System.out.println(a.charAt(a.length()-3));
		System.out.println(b.indexOf("zid"));
		
		String ret = a.replace("dog", "Ge");
		System.out.println(ret);  // String是不可变字符串，返回新的字符串
		
		System.out.println(a.startsWith("qizi"));  // 判断是否以xx开头
		System.out.println(a.endsWith("zi"));  // 判断是否以xx结尾
		System.out.println(b.substring(2, 4));  // 提取子字符串
		
		System.out.println("QiziDOG".toLowerCase());  // 转小写字母
		System.out.println("QiziDOG".toUpperCase());  // 转大写字母
		System.out.println("  Qizi DOG  ".trim());  // 去除首位的字符
	}
}
