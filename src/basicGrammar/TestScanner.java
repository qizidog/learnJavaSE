package basicGrammar;
/**
 * 测试Scanner获得键盘输入
 * @author qizidog
 *
 */

import java.util.Scanner;


public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input your name:");
		String name = scanner.nextLine();
		System.out.println("please input your hobit:");
		String hobit = scanner.nextLine();
		System.out.println("please input your age:");
		int age = scanner.nextInt();
		
		System.out.println("###########################");
		System.out.println("姓名："+name+"\n"+"爱好："+hobit+"\n"+"年龄："+age);
		System.out.println(1+1);
	}
}
