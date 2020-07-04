package learnIO;

import java.io.UnsupportedEncodingException;

/**
 * 字符->字节：编码 encode
 * 字节->字符：解码 decode
 * @author qizidog
 *
 */
public class TestEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		test01();
	}
	
	public static void test01() throws UnsupportedEncodingException {
		String str = "性命生命使命a";
		// 编码：字节数组
		byte[] datas = str.getBytes(); // 默认使用工程的字符集
		for (byte b : datas) {
			System.out.print(b+", ");
		}
		System.out.println();
		// GBK编码，1个ASCII字符1Byte,其他固定占2Byte
		System.out.println(datas.length);
		
		// UTF-8编码，1个中文3Byte，1个ASCII字符1Byte
		System.out.println(str.getBytes("UTF-8").length);

		
		
		// 解码：字符串
		String msg = new String(datas); // String的一种构造器，通过Byte[]生成字符串
		System.out.println("msg:"+msg);
		String msg2 = new String(datas, 0, datas.length, "GBK"); // 另一种构造器
		System.out.println("msg2:"+msg2);
		
		// 乱码：
		// 1.字节数不够
		String msg3 = new String(datas, 0, datas.length-1, "GBK"); // a占1Byte，length-1仍可解码
		System.out.println("msg3:"+msg3);

		String msg4 = new String(datas, 0, datas.length-2, "GBK"); // length-2破坏了“命”的编码
		System.out.println("msg4:"+msg4);

		// 2.字符集不统一
		String msg5 = new String(datas, 0, datas.length, "utf8"); // datas是GBK字符集编码得到的Byte[]
		System.out.println("msg5:"+msg5);
		
		
	}
}
