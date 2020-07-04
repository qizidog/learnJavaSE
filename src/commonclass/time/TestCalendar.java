package commonclass.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @function 测试calendar类
 * @author qizidog
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		// Calendar类是一个抽象类，GreorianCalendar是他的子类
		Calendar calendar = new GregorianCalendar(2020,3,15);
		
		// 获得日期的相关元素
		System.out.println(calendar.get(calendar.YEAR));
		System.out.println(calendar.get(calendar.MONTH));
		System.out.println(calendar.get(calendar.DATE));
		
		// 设置日期的相关元素
		Calendar cld = new GregorianCalendar();  //无参数则默认当前日期
		cld.set(Calendar.YEAR, 2017);
		cld.set(Calendar.MONTH, 4);
		cld.set(Calendar.DATE, 5);
		System.out.println(cld);

		// 日期的计算
		cld.add(Calendar.YEAR, 3);  // 加上三年
		System.out.println(cld);
		
		// 日期对象和时间对象的转化
		Date date = calendar.getTime();
		System.out.println(date);
		
		cld.setTime(new Date());
		System.out.println(cld);
	}
}
