package basicGrammar;
/**
 * 测试while循环
 * @author qizidog
 *
 */
public class TestWhile {
	public static void main(String[] args) {
		//计算1~100的和
		int i=1;
		int sum=0;
		while(i<=100) {
			sum += i++;
		}
		System.out.println("计算的总和是："+sum);
	}
}
