package learnMultiThread;

/**
 * @author qizidog
 * @date 2020.04.26\
 * 静态代理：（两种角色应实现相同的接口）
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry(); 
        
    }

}

interface Marry{
    void happyMarry();
}

// 真实角色
class You implements Marry{
    public void happyMarry() {
        System.out.println("洞房花烛夜");
    }
}

// 代理角色
class WeddingCompany implements Marry{
    private Marry target;
    
    public void happyMarry() {
        System.out.println("准备工作");
        this.target.happyMarry();
        System.out.println("后续事宜");
    }
    
    public WeddingCompany(Marry who) {
        this.target = who;
    }
}
