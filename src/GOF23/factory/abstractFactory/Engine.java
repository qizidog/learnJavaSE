package GOF23.factory.abstractFactory;

public interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转得快！");
    }

    @Override
    public void start() {
        System.out.println("启动快，可以自动起停！");
    }
    
}

class PoorEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转得慢！");
    }

    @Override
    public void start() {
        System.out.println("启动慢，手动起停！");
    }
    
}
