package learnArray;

public class TestArray {
	public static void main(String[] args) {
		int[] arr01 = new int[10];  // 动态初始化方法（创建后赋值）
		arr01[0] = 1;
		arr01[1] = 2;
		arr01[2] = 3;
		for (int i = 0; i < arr01.length; i++) {
			arr01[i] = 20*i;
			System.out.println(arr01[i]);
		}
		
		
		String[] arr02 = new String[3];  // 默认初始化方法（创建后不赋值）
		
		
		User[] arr03 = new User[3];
		arr03[0] = new User(1231, "qizidog");
		arr03[1] = new User(1234, "qizigou");
		arr03[2] = new User(504, "yuruiling");
		
		for(int i=0; i<arr03.length; i++) {
			System.out.print(arr03[i].getId());
			System.out.println(arr03[i].getName());
		}
		
		// foreach循环；用于读取数组中全部元素的值，不能修改元素的值
		for (User usr : arr03) {  /*for（数据类型 元素名字 ： 数组名字）*/
			System.out.println(usr.getName());
		}
		
		
		int[] arr04 = {1,2,3,4,5,6,7};  // 静态初始化方法（创建的同时赋值）
		User[] arr05 = {new User(100, "abc"), 
						new User(101, "def"),
						new User(102, "ghi")
						};
		
	}
}

class User{
	private int id;
	private String name;
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
