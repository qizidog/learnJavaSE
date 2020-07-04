package learnIO.Node;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestByteArrayOutput {
	public static void main(String[] args) {
		output();
	}
	
	public static void output() {
//		OutputStream os = new ByteArrayOutputStream();  // 不需要指定目的地 
		// 写成ByteArrayOutputStream（ByteArrayOutputStream中有OutputStream中没有的方法，不能实现多态）
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		byte[] datas = "talk is cheap, show me the code.".getBytes();
		try {
			os.write(datas);
			os.flush();

			// 查看一下保存的结果
			// 如果在创建os的时候将其定义为OutputStream类型，则tobytearray方法无法使用
			byte[] bt = os.toByteArray();
			System.out.println(bt.length+"-->"+new String(bt));
			
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			System.out.println("字节数组流不需要关闭");
		}
		
	}
}
