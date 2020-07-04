package GOF23.singleton;

/**
 * @author qizidog
 * @date 2020.05.26
 * 通过枚举类实现单例模式
 * 可以避免反射和序列化攻击；调用效率较高；线程安全
 * 不能延时加载
 */
public enum SingletonDemo05 {
    // 只设置一个枚举变量
    INSTANCE;  // 在jvm中INSTANCE会自动实例化一个SingletonDemo04，天然是线程安全的
    
    private int age = 18;
    private String name = "qwe";
    private int id = 1001;
    
    public static SingletonDemo05 getInstance() {
        return INSTANCE;
    }
    
    @Override
    public String toString() {  // 重写一下toString方法，看起来直观一点
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    
    public static void main(String[] args) {
        System.out.println("直接以enum作为一个类来使用，是一个天然的单例模式");
        System.out.println(SingletonDemo05.getInstance());
        System.out.println(SingletonDemo05.getInstance());
    }
}
