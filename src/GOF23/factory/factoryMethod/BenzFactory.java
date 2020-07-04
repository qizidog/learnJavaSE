package GOF23.factory.factoryMethod;

public class BenzFactory implements factory {
    
    @Override
    public Car createCar() {
        return new Car_Benz();
    }
}
