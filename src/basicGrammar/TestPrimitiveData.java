package basicGrammar;
/**
 * 测试数据基本类型
 * @author qizidog
 *
 */

public class TestPrimitiveData {
	public static void main(String[] args) {
		// 测试整型变量
		int a=15;
		int b=0b1111;  //以0b开头的是2进制
		int c=015;  // 以0开头的是8进制
		int d=0x15;  // 以0x开头的是16进制
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		// 整型变量
		byte aa=127;  // 2字节，范围-128~127
		short bb=30000;  //  4字节，范围-3w~3w
		int cc=2100000000;  //  8字节，范围-21亿~21亿
		long dd=7400000000L;  //  16字节，范围-2^63~2^63-1
		// Java语言的整型常数默认为int型，声明long型常量可以后加‘l’或‘L’
		
		// 浮点型变量
		float fa=3.14F;  // 单精度，尾数可以精确到7位有效数字，使用float类型时需要显示的加“F"
		double fb=3.1415926525;  // 双精度，尾数精确度越是float的两倍
		
		// 布尔类型
		boolean flag=true;  // false
	}
}
