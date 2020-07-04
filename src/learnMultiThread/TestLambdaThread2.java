package learnMultiThread;

/**
 * @author qizidog
 * @date 2020.04.26
 * lambda表达式简化（用一次）线程的使用
 */
public class TestLambdaThread2 {
    public static void main(String[] args) {
        // 无参数匿名函数
        new Like() {
            public void lambda() {
                System.out.println("yep");
            }
        }.lambda();
        
        Like lk = ()->{
            System.out.println("yep2");
        };
        lk.lambda();

        // 带参数匿名函数
        System.out.println(
            new Love() { // 直接使用接口并重写lambda方法
                public int lambda(int a) {
                    return a+9;
                }
            }.lambda(10)
        );

        
        Love lv = (int a)->{
            return a+9;
        };
        
        lv = (a)->{ // 可以省略类型
            return a+10;
        };
        
        lv = a->{ // 如果只有一个参数，可以省略括号
            return a+11;
        };
        
        lv = a -> a+12; // 如果只有一句主体，可以省略{}，return语句的话，return关键词也去掉
        System.out.println(lv.lambda(30));
        
    }
}

interface Love{
    int lambda(int z);
}

class ILove implements Love{
    public int lambda(int a) {
        return a+10;
        
    }
}


interface Like{
    void lambda();
}

class ILike implements Like{
    public void lambda() {
        System.out.println("yes");
    }
}

class IILike extends ILike{
    
}
