package commonclass.time;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();  // 什么参数都不传则默认是当前电脑时间
		System.out.println(d);
		long t = d.getTime();  // 获得日期转换成的毫秒数
		System.out.println(t);
		
		Date d2 = new Date(120, 2, 13);  // 这个构造方法已经被弃用了
		System.out.println(d2+"  "+d2.after(d));  // after用于判断一个日期位于另一个日期之后
				
	}
}
