package GOF23.builder;

public class Airship {
    private OrbitalModule orbitalModule;  // 轨道舱
    private Engine engine;  // 发动机
    private EscapeTower escapeTower;  // 逃逸塔
    
    public void launch() {
        System.out.println("冲！发射！");
    }
    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }
    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public EscapeTower getEscapeTower() {
        return escapeTower;
    }
    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
    @Override
    public String toString() {
        return "宇宙飞船 with "+this.engine.getName()
        +" "+this.escapeTower.getName()
        +" "+this.orbitalModule.getName();
    }
}


class OrbitalModule{
    private String name;
    
    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

class Engine{
    private String name;
    
    public Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

class EscapeTower{
    private String name;
    
    public EscapeTower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
