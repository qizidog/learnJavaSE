package oo.oo2;
/**
 * 测试匿名内部类
 * @author qizidog
 *
 */

public class TestLambdaInnerClass {
	public static void main(String[] args) {
		test_lambda(new A() {  // 匿名内部类

			@Override
			public void aa() {
				System.out.println("重写aa方法");
			}
			
		});
	}
	
	static void test_lambda(A a_obj) {  // 该方法要求输入参数为A类型
		System.out.println("此处调用aa方法");
		a_obj.aa();
	}
}


interface A{ //接口类不能被实例化，其方法必须被继承才能使用
	void aa();
}
