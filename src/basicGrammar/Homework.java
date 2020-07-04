package basicGrammar;
/**
 * 第二章作业练习题
 * @author qizidog
 *
 */
/*
import java.util.Scanner;

// 输入圆的半径，返回周长和面积的计算结果

public class Homework {
	public static void main(String[] args) {
		System.out.println("请输入圆的半径");
		Scanner scanner = new Scanner(System.in);
		double radius = scanner.nextDouble();
		double perimeter = 2*3.14*radius;
		double area = 3.14*radius*radius;
		System.out.println("该圆的周长为：2*3.14*"+radius+"="+perimeter);
		System.out.println("该圆的面积为：3.14*"+radius+"*"+radius+"="+area);
	}
}
*/

import java.util.Scanner;

// 数字加密

public class Homework{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个四位的整数：");
		int num = scanner.nextInt();
		int a = num%10;
		int b = num/10%10;
		int c = num/100%10;
		int d = num/1000%10;
		int out_num = (a+5)%10*1000 + (b+5)%10*100 + (c+5)%10*10 + (d+5)%10;
		System.out.println(out_num);
	}
}











