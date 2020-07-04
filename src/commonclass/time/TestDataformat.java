package commonclass.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qizidog
 * @function 测试实践对象和字符串之间的相互转换
 */

public class TestDataformat {
	public static void main(String[] args) throws ParseException {
		// DateFormat类是一个抽象类，我们一般使用SimpleDateFormat类(DateFormat类的子类)
		// 之所以使用SimpleDateFormat类却把他定义为DateFormat类，
		// 是因为SimpleDateformat类没有实现format(Date)的方法
		// SimpleDateFormat df = new SimpleDateFormat();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		String str = df.format(new Date(20000));  // 把时间对象转化成指定格式的字符串
		System.out.println(str);
		
		// 把字符串按指定的格式转化的相应的时间对象
		DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		
		Date d = df2.parse("1983年10月29日 08:30:00");
		System.out.println(d);
		
		// 测试其他格式字符的功能
		/**
		 * 一年中的第几天； 一月中的第几天
		 * 一年中的第几周； 一月中的第几周
		 * 时区
		 */
		DateFormat df3 = new SimpleDateFormat("D");
		
		System.out.println(df3.format(new Date()));
	}
}
