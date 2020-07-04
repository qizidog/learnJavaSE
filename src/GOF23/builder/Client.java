package GOF23.builder;

public class Client {
    public static void main(String[] args) {
        AirshipDirector ad = new SxtAirshipDirector(new SxtAirshipBuilder());
        Airship airship = ad.directAirship();
        System.out.println(airship);
        airship.launch();
    }
}
