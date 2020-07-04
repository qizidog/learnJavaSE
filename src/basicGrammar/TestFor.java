package basicGrammar;
/**
 * 测试for循环
 * @author qizidog
 *
 */

public class TestFor {
	public static void main(String[] args) {
//		int sum=0;
//		for(int i=1; i<=10; i=i+2) {
//			sum +=i;
//		}
//		System.out.println(sum);
		
		// 斐波拉契数列
		for(int i=0, j=1, k; j<100; ) {
			System.out.print(j+",");
			k=j; j+=i; i=k;
//			System.out.println("i:"+i+",j:"+j);
		}
	}
}
