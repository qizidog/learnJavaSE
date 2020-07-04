package basicGrammar;
/**
 * 测试变量
 * @author qizidog
 *
 */

public class TestVariable {
	
	int a;  // 成员变量，只需要声明，不需要初始化，如果没有初始化，按系统默认的值自动初始化；从属于对象
	static int b;  // 静态对象，从属于类
	
	public static void main(String[] args) {
		
		{
			int c;  // 局部变量，从属于语句块
		}
		
		int age;  // 局部变量，从属于方法需要声明并做初始化，否则无法使用
		int height=168;
		double eyesight=4.0;
		long number=2019211162;
		String name="qizidog";
		char _type='a';
		short cc=22122;
		
		// 常量 constant，即不可变的量
		final char sex='男';  // 加上final之后，一个变量就被固定为常量
		
		
	}
}
