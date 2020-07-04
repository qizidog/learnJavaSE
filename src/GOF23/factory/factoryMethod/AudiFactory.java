package GOF23.factory.factoryMethod;

public class AudiFactory implements factory {

    @Override
    public Car createCar() {
        return new Car_Audi();
    }

}
