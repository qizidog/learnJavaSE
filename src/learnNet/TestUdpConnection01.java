package learnNet;

// UdpConnection类在TestUdpServerClient.java里面
public class TestUdpConnection01 {
    public static void main(String[] args) {
        new Thread(new UdpConnection(19980, 19518, 29518), "qizidog").start();
    }
}
