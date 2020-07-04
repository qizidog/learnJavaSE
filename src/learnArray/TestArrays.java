package learnArray;

/**
 * @function 测试Arrays静态类以及2维数组
 * @author qizidog
 */

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
//		testArrs();
		test2DArrs();
	}
	
	public static void testArrs() {
		int[] a = {10, 20, 30, 14, 53, 21, 20};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void test2DArrs() {
//		int[] a = new int[3];  // 基本类型的数组声明
//		a = new int[]{1,2,3};  // 基本类型的数组赋值
//		int[] a = {1,2,3};  // 上面两句直接合并为这一句
		int[] a = new int[]{1,2,3};  // 或者那两句也可直接合并为这一句
		
		int[][] b = new int[3][];  // 声明一个可以存放3个数组的二维数组
		b[0] = new int[]{10,20};  // 为二维数组的三个子数组赋值(不同的3种方式)
		b[1] = new int[3];
		b[1][0] = 30;
		b[1][1] = 40;
		b[1][2] = 50;
		b[2] = new int[]{60,70,80};
		
//		int[][] b = {{10,20}, new int[]{30,40,50}, {60,70,80}}; // 这一句和上面几句的作用相同
		
		// 循环打印二维数组中的每一个数组
		for(int i=0; i<b.length;i++) {
			System.out.println(Arrays.toString(b[i]));
			
		}
		
	}
}
