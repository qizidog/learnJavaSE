package GOF23.builder;

public class SxtAirshipDirector implements AirshipDirector{
    
    private AirshipBuilder builder;
    
    
    public SxtAirshipDirector(AirshipBuilder builder) {
        this.builder = builder;
    }


    @Override
    public Airship directAirship() {
        Engine e = builder.buildEngine();
        EscapeTower et = builder.buildEscapeTower();
        OrbitalModule om = builder.buildOrbitalModule();
        Airship airship = new Airship();
        airship.setEngine(e);
        airship.setEscapeTower(et);
        airship.setOrbitalModule(om);
        return airship;
    }

}
