package commonclass.string;

/**
 * 
 * @author qizidog
 * @function 测试StringBuilder的常用方法
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		StringBuilder sbl = new StringBuilder();
		
		for(int i=0; i<26; i++) {
			char temp = (char)('a' + i);
			sbl.append(temp);
		}
		System.out.println(sbl);
		
		sbl.reverse();  // 倒序
		System.out.println(sbl);
		
		sbl.setCharAt(25, 'A');  // 更改
		sbl.insert(1, "Qi").delete(0, 1);  // 插入.删除
		System.out.println(sbl);
	}
}
