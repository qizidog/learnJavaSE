package oo.oo1;

public class Student {
	int name;
	int age;
	int sex;
	Computer comp;
	
	void eat() {
		System.out.println("i'm eat lunch.");
		System.out.println("my computer is "+comp.brand);
	}
	
	void sleep() {
		System.out.println("Ssh, i'm sleep...");
	}
	
	// 构造方法，无参数的构造方法可以由系统自动创建
	Student(){
		
	}
	
	public static void main(String[] args) {
		Student sdt = new Student();
		Computer comp = new Computer();
		comp.brand = "Lenovo";
		sdt.comp = comp;
		sdt.eat();
		sdt.sleep();
		
	}
}

class Computer{
	String brand;
}


