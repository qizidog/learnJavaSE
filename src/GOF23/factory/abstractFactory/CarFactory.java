package GOF23.factory.abstractFactory;

/**
 * @author qizidog
 * @date 2020.05.28
 * 测试抽象工厂模式
 * 将产品分解为多种组装件进行抽象，适合于更加复杂的生产过程
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}


class LuxuryCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
    
}

class PoorCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new PoorEngine();
    }

    @Override
    public Seat createSeat() {
        return new PoorSeat();
    }

    @Override
    public Tyre createTyre() {
        return new PoorTyre();
    }
    
}
