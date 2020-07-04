package GOF23.factory.abstractFactory;

public interface Seat {
    void massage();
}

class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("可以按摩！");
    }
    
}

class PoorSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("硬座！");
    }
    
}
