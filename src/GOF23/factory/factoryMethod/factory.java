package GOF23.factory.factoryMethod;

/**
 * @author qizidog
 * @date 2020.05.28
 * 测试工厂方法模式
 * 在简单工厂的基础上，对工厂类也进行了抽象，解决了新增产品类时需要修改业务代码的问题
 */
public interface factory {
    
    public abstract Car createCar();
    
//    jdk1.8之后允许在接口中添加静态方法
//    接口中定义的静态方法需要加上方法体，在实现类中不需要实现接口的静态方法
//    不能通过接口实现类的对象来调用接口当中的静态方法，而应通过接口名称直接调用
//    public static Car createCar1() {
//        return null;
//    };
//
//    私有静态方法好像要1.9之后才能用
//        private static Car createCar1() {
//            return null;
//        };
//    static Car createCar2() {
//        return null;
//    };
    
    
//    从jdk1.9开始，接口当中允许定义私有方法(解决多个默认方法之间重复代码问题)
//    private void methodCommon() {  // 重复的内容 放在一起
//        System.out.println("AAA");
//        System.out.println("BBB");
//        System.out.println("CCC");
//    }
//    public default void methodDefault1() {
//        System.out.println("默认方法1");
//        methodCommon();
//    }
//    public default void methodDefault2() {
//        System.out.println("默认方法2");
//        methodCommon();
//    }

}
