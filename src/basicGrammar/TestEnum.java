package basicGrammar;

/**
 * @author qizidog
 * @date 2020.05.26
 * 测试enum类
 */
public enum TestEnum {
    A, B, INSTANCE;
    private String info = "this is enum ";
    
    public String getInfo() {
        return this.info+this;
    }
    
    public static void main(String[] args) {
        System.out.println(TestEnum.A);
        System.out.println(TestEnum.B);
        System.out.println(TestEnum.INSTANCE instanceof TestEnum);
        
        System.out.println("--------");
        for (TestEnum e:TestEnum.values()) {
            System.out.println(e);
        }
        System.out.println("--------");
        
        System.out.println(TestEnum.valueOf("A"));
        
        System.out.println(TestEnum.A.getInfo());
        System.out.println(TestEnum.B.getInfo());
        System.out.println(TestEnum.INSTANCE.getInfo());
    }
}
