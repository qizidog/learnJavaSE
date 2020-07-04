package basicGrammar;
/**
 * 测试方法
 * @author qizidog
 *
 */
public class TestMethod {
	public static void main(String[] args) {
		TestMethod tm = new TestMethod();
		tm.printsth();
		tm.get_sum(1996, 12*2, 31*2);
	}
	
	// 没有任何返回值和参数的函数
	void printsth() {
		System.out.println("从前有只启子狗");
		System.out.println("once upon a time, there is a qizidog");
	}
	
	// 没有返回值，有参数的函数
	void get_sum(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	// 有返回值和参数的函数（需要在前面定义返回值的类型）
	int get_sum2(int a, int b, int c) {
			System.out.println(a+b+c);
			return a+b+c;
		}
}
