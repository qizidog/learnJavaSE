package commonclass.string;
/**
 * 测试代码点和代码单元
 * @author qizidog
 * 一个字符对应一个代码点，一个代码点可能由一个或多个代码单元组成
 */
public class CodePointUnit {
    public static void main(String[] args) {
        String str = "qizi周启帆";
        System.out.println(str.length());  // 代码单元数量
        System.out.println(str.charAt(4));  // 获得第5个代码单元
        System.out.println(str.codePointCount(0, str.length()));  // 代码点数量
        System.out.println(str.codePointAt(str.offsetByCodePoints(0, 4)));  // 获得第5个代码点
        System.out.printf("woshi%s%d", str, 20);
        System.out.println();
        System.out.printf("%4.3f", 3.14);
    }
}
