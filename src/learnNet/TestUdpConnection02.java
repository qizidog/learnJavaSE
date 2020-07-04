package learnNet;

//UdpConnection类在TestUdpServerClient.java里面
public class TestUdpConnection02 {
    public static void main(String[] args) {
        new Thread(new UdpConnection(29980, 29518, 19518), "hayu").start(); 
    }
}
