package basicGrammar;
/**
 * 测试位算术运算符和变量类型转换
 * @author qizidog
 *
 */

public class TestOperator {
	public static void main(String[] args) {
		int length=120;
		System.out.println(length>>3);  // 右移3位相当于除以三次2
		System.out.println(length<<2);  // 左移2位相当于乘以两次2
		
		int a = 1;
		float b = a;
		double c = a;
		a = (int)b;
		
	}
}
