package GOF23.factory.simpleFactory;

public class Client {
    public static void main(String[] args) {
        // 没有工厂模式时的调用(客户端同时与接口类和多个实现类打交道)
        Car benz = new Car_Benz();
        Car audi = new Car_Audi();
        benz.run();
        audi.run();
        
        // 借助工厂模式的调用(客户端仅与接口类和工厂类打交道，减少类之间的耦合)
        benz = SimpleFactory.getBenz();
        audi = SimpleFactory.getAudi();
        benz.run();
        audi.run();
        
    }
}
