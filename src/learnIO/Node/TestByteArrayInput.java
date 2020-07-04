package learnIO.Node;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组输入流
 * @author qizidog
 *
 */
public class TestByteArrayInput {
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
		byte[] data = "talk is cheap, show me the code.".getBytes();
		
		InputStream is = new ByteArrayInputStream(data);
		
		// 显示一下bytearray中的内容
		byte[] flush = new byte[9];
		try {
			while(-1!=is.read(flush)) {
				System.out.println(new String(flush));
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// bytearray不需要关闭
			System.out.println("bytearray不需要关闭");
		}
		
		
	}
}
