package oo.oo2;

/**
 * 测试内部类（静态、非静态）
 * @author qizidog
 *
 */
public class TestInnerclass {
	public static void main(String[] args) {
		//创建外部类对象
		Outer outer = new Outer();
		outer.test_outer();
		
		//创建内部非静态类对象
		Outer.Inner inner = new Outer().new Inner();
//		outer.new Inner().test_inner();  //这种方法也可以
		inner.test_inner();
		
		//创建内部静态类对象
		Outer.Inner2 inner2 = new Outer.Inner2();
	}
}

class Outer{
	// 外部类不能直接访问非静态内部类的属性和方法
	
	private int age=24;
	static int egg=0;
	
	public void test_outer() {
		System.out.println("测试外部类");
	}
	
	class Inner{
		// 非静态内部类不是使用static修饰方法
		int age = 18;
		public void test_inner() {
			int age = 0;
			System.out.println("测试内部类");
			System.out.println("访问外部成员的属性"+Outer.this.age); //可以访问private
			System.out.println("访问内部成员的属性"+this.age);
			System.out.println("访问局部属性"+age); // 如果局部属性age不存在，则age=this.age
		}
	}
	
	static class Inner2{
		static int egg = 19;
		static void test_inner2() {
			System.out.println("访问外部成员的属性"+Outer.egg);  // 只能访问外部类的static属性和方法
			System.out.println("访问外部成员的属性"+egg);  // 静态属性
		}
	}
}
