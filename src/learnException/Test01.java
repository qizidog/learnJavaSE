package learnException;
/**
 * runtime exception 运行时异常
 * @author qizidog
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		if(b!=0) {
			System.out.println(a/b);
		}else {
			System.out.println("b is 0.");
		}
		
		String str = null;
		if(str!=null) {
			str.length();  // 空指针异常
		}else {
			System.out.println("s is null");
		}
		
	}
}
