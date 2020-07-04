package oo.oo1;
/**
 * @function 测试访问控制符
 * @author qizidog
 */

import oo.oo2.Vehicle;

public class Vehicle4 extends Vehicle{
	public static void main(String[] args) {
		Vehicle4 car4 = new Vehicle4();
//		System.out.println(car4.number);  //private变量仅在同一个class中可用
//		System.out.println(car4.label);  //default变量需在一个包中可用
		System.out.println(car4.color);
		System.out.println(car4.price);
}
}

class Vehicle5 {
	public static void main(String[] args) {
		Vehicle4 car5 = new Vehicle4();
//		System.out.println(car5.number);  //private变量仅在同一个class中可用
//		System.out.println(car5.label);  //default变量需在一个包中可用
//		System.out.println(car5.color);  //protected变量在同一个包或子类中可用
		System.out.println(car5.price);  //public变量在所有类中均可用
}
}
