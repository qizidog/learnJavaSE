package GOF23.factory.simpleFactory;

/**
 * @author qizidog
 * @date 2020.05.27
 * 简单工厂模式（静态工厂模式）
 * 不完全满足OCP原则，新增实现类需要修改业务代码
 */
public class SimpleFactory {
    public static Car getBenz() {
        return new Car_Benz();
    }
    
    public static Car getAudi() {
        return new Car_Audi();
    }
}
