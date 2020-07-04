package oo.oo2;
/**
 * @function 测试访问控制符
 * @author qizidog
 *
 */
public class Vehicle {
	private int number = 12345;
	String label = "Posture";
	protected String color = "red";
	public int price = 10000;
	
	protected int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		System.out.println(car.number);
		System.out.println(car.label);
		System.out.println(car.color);
		System.out.println(car.price);
	}
}

class Vehicle2{	
	void main() {
		Vehicle car2 = new Vehicle();
//		System.out.println(car2.number);  //private变量仅在同一个class中可用
		System.out.println(car2.label);  
		System.out.println(car2.color);
		System.out.println(car2.price);
	}
}

class Vehicle3 extends Vehicle{	
	void main() {
		Vehicle car3 = new Vehicle();
//		System.out.println(car3.number);  //private变量仅在同一个class中可用
		System.out.println(car3.label);
		System.out.println(car3.color);
		System.out.println(car3.price);
//		Vehicle cc = new Vehicle2();
		Vehicle cc = new Vehicle3();
	}
}

