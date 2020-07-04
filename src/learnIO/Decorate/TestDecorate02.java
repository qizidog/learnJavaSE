package learnIO.Decorate;
/**
 * 1、抽象组件：需要装饰的抽象对象（接口或父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类：包含了对抽象组件的引用及装饰者的共有方法（接口或父类）
 * 4、具体装饰类：装饰用的对象
 * @param args
 */
public class TestDecorate02 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		System.out.println(coffee.info()+"  "+coffee.cost());

		Drink sugarcaffee = new Sugar(coffee);
		System.out.println(sugarcaffee.info()+"  "+sugarcaffee.cost());
		
		Drink milkcoffee = new Milk(coffee);
		System.out.println(milkcoffee.info()+"  "+milkcoffee.cost());

		Drink sugarmilkcoffee = new Milk(sugarcaffee);
		System.out.println(sugarmilkcoffee.info()+"  "+sugarmilkcoffee.cost());

	}
}

// 抽象组件
interface Drink{
	double cost();
	String info();
}

// 具体组件
class Coffee implements Drink{
	private String name="原味咖啡";
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
	
}


// 抽象装饰类
abstract class Decorate implements Drink{
	// 对抽象组件的引用
	private Drink drink;
	
	public Decorate(Drink drink) {
		this.drink = drink;
	}
	
	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
	
}

// 具体的装饰类
class Milk extends Decorate{
	public Milk(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost()*4;
	}
	
	public String info() {
		return super.info()+"加入了牛奶";
	}
}

class Sugar extends Decorate{
	public Sugar(Drink drink) {
		super(drink);
	}

	public double cost() {
		return super.cost()*2;
	}
	
	public String info() {
		return super.info()+"加入了蔗糖";
	}
}
