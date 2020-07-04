package commonclass.math;

import java.util.Random;

public class TestMath {
	public static void main(String[] args) {
		// Math类
		System.out.println(Math.ceil(2.4));
		System.out.println(Math.floor(2.6));
		System.out.println(Math.round(2.4));
		System.out.println(Math.round(2.6));
		System.out.println(Math.abs(-4));
		System.out.println(Math.pow(19, 2));
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Math.random());// [0,1)
		
		
		// Random类
		Random rand = new Random();
        //随机生成[0,1)之间的double类型的数据
        System.out.println("随机生成[0,1)之间的double类型的数据："+rand.nextDouble());
        //随机生成45-99之间的double类型数据
        System.out.println("随机生成45-99之间的double类型数据："+(45+44*rand.nextDouble()));
        //随机生成int类型允许范围之内的整型数据
        System.out.println("随机生成int类型允许范围之内的整型数据："+rand.nextInt());
        //随机生成[0,1)之间的float类型的数据
        System.out.println("随机生成[0,1)之间的float类型的数据："+rand.nextFloat());
        //随机生成false或者true
        System.out.println("随机生成false或者true："+rand.nextBoolean());
        //随机生成[0,10)之间的int类型的数据
        System.out.println("随机生成[0,10)之间的int类型的数据："+rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据
        System.out.println("随机生成[20,30)之间的int类型的数据："+(20 + rand.nextInt(10)));
        //随机生成[20,30)之间的int类型的数据（此种方法计算较为复杂）
        System.out.println("随机生成[20,30)之间的int类型的数据："+(20 + (int) (rand.nextDouble() * 10)));
	}
}
