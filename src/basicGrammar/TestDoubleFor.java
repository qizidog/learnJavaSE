package basicGrammar;
/**
 * 测试嵌套循环
 * @author qizidog
 *
 */

public class TestDoubleFor {
	public static void main(String[] args) {
//		for(int i=1; i<=4; i++) {
//			for(int j=1; j<=6; j++) {
//				System.out.print(i*2+"\t");
//			}
//		System.out.print('\n');
//		}
		
		// 九九乘法表
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j+"*"+i+"="+i*j+'\t');
			}
		System.out.print('\n');
		}
		
		for(int i=1; i<30; i++) {
			if(i%3==0) {
				System.out.print(i+"\t");
			}

		}
		
		// 输出101-150之间所有的质数
		System.out.println();
		boolean flag;
		for(int i=101; i<150; i++) {
			flag=true;
			for(int j=2; j<i/2; j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.print(i+"\t");
			}
		}
		

		System.out.print("\n############\n");
		abc: for(int i=101; i<150; i++) {
			for(int j=2; j<i/2; j++) {
				if(i%j==0) {
					continue abc;
				}
			}
			System.out.print(i+"\t");
		}
	}
}
