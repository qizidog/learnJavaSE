package commonclass.string;

/**
 * 测试自动装箱，自动拆箱
 * @author qizidog
 *
 */
public class TestAutoBox {
	public static void main(String[] args) {
		// 编译器自动帮我们完成装箱和拆箱
		Integer a = 123;  // 装箱：Integer a = Integer.valueOf(234);
		int b = a;  // 拆箱：int b = a.intValue();
		
		String str = "unique";  // 字符串的核心是一个char[]，即字符类型的数组（不可变字符序列）
		String str2 = str.substring(3,6);
		System.out.println(
			new String(new char[] {'1','2','3','q','i','z','i','d','o','g','3'},
					3, 7));  // substring内部调用的
		
		
		// StringBuilder线程不安全，效率高(一般用这个)；StringBuffer线程安全，效率低
		StringBuilder sbl = new StringBuilder("abcdefg");
		StringBuffer sbf = new StringBuffer();
		
		System.out.println(sbl.hashCode()+ "  " 
				+Integer.toHexString(sbl.hashCode())+ "  "+sbl);
		sbl.setCharAt(3, 'D');
		System.out.println(sbl.hashCode()+ "  " 
				+Integer.toHexString(sbl.hashCode())+ "  "+sbl);	
		}
}
