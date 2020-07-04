package commonclass.string;

/**
 * 测试包装类
 * @author qizidog
 *
 */

public class TestWrapperClass {
	public static void main(String[] args) {
		// 基本数据类型转换成包装类对象的2种方法
		Integer a = new Integer(3);
		Integer b = Integer.valueOf(3);  // 官方推荐
		
		// 把包装类对象转换为基本数据类型
		int c = b.intValue();
		double d = b.doubleValue();
		
		// 把字符串转化为包装类对象
		Integer e = new Integer("222");
		Integer f = Integer.parseInt("222");
		
		// 把包装类对象转换成字符串
		String str = f.toString();
	}
}
