package learnIO.Decorate;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBufferedInputStream {
	public static void main(String[] args) {
	input();
	}
	
	public static void input() {
		File src = new File("E:\\java_files\\learnjava\\src\\learnIO\\input.txt");
		
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));  // 直接在节点流外面套处理流
			
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=bis.read(flush))!=-1) {
				System.out.println(new String(flush, "utf8"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bis!=null) {
				try {
					bis.close(); // 内部的节点流会自动关闭
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
