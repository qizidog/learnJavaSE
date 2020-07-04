package oo.oo2;

/**
 * 测试接口和抽象类
 * @author qizidog
 *
 */



public class TestInterface implements MyInterface, HisInterface{
	public void function1() {
		System.out.println("override");
	}
	
	@Override  // 这句可写可不写
	public void function2() {
		System.out.println("override2");
	}
	
	public static void main(String[] args) {
		
	}

}

interface MyInterface{ // 接口类默认只能被继承，且所有方法必须被实现重写
	/* 接口类中的方法全部默认为是抽象方法
	 * 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是
     * 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract
     * interface可以被多继承，而class只能单继承
     */
	public static final String NAME = "qizidog";
	boolean HONEST = true;
	
	public abstract void function1();
}

interface HisInterface{
	void function2();
}

abstract class AbsClass{
	/* 含有抽象方法的类必须为抽象类
	 * 抽象类中也可以含有非抽象方法
	 * 抽象类的所有抽象方法都必须被子类实现
	 */
	
	abstract boolean funtion3();
	
	public void function4() {
		System.out.print(true);
	}
}



