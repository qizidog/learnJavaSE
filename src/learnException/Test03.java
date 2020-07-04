package learnException;

public class Test03 {
	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(-10);
	}
	
	
}

class Person{
	private int age;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age<0) {
			throw new IllegalAgeException("年龄不能为负数");
		}
		this.age = age;
		System.out.println(this.age);
	}
}


class IllegalAgeException extends RuntimeException{  // Exception
	// 继承RuntimeException则为运行时异常，在运行的时候才会抛出异常
	// 继承Exception则为可检测异常，在编译时即可检测到，需用try-catch处理或throw抛出
	public IllegalAgeException() {
		
	}
	
	public IllegalAgeException(String msg) {
		super(msg);
	}
}
