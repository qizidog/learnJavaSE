package GOF23.factory.abstractFactory;

public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("旋转不磨损");
    }
    
}

class PoorTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("旋转磨损快");
    }
    
}
