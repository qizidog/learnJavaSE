package commonclass.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @function 可视化日历程序
 * @author qizidog
 *
 */
public class CalendarView {
	public static void main(String[] args) throws ParseException {
		calendarView();
	}
	
	public static void calendarView() throws ParseException {
		System.out.println("请输入日期（格式：2017-04-05）");
		String str = new Scanner(System.in).nextLine();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);  // 将日期设定为同月第一天
//		System.out.println(calendar);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		int iday = calendar.get(Calendar.DAY_OF_WEEK)-1;
		for(int i=0; i<iday; i++) {
			System.out.print("\t");
		}
		
		int m = calendar.getActualMaximum(Calendar.DATE);  // 获得指定项的最大值
		for(int i=0; i<m; i++) {
			int temp = calendar.get(Calendar.DAY_OF_MONTH);
			if(today!=temp) {
				System.out.print(temp+"\t");
			}else {
				System.out.print(temp+"*\t");
			}
			
			if(calendar.get(Calendar.DAY_OF_WEEK) == 7) {  // 如果是周六就换行
				System.out.println();
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		System.out.println();
		System.out.println("本月为"+calendar.get(Calendar.MONTH) +"月，本月共"+m+"天");
	}
}
