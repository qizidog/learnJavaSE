package learnIO.Decorate;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestBufferedOutputStream {
	public static void main(String[] args) {
		output();
	}
	
static void output() {
		
		// 1.创建源
		File dest = new File("E:\\java_files\\learnjava\\src\\learnIO\\output.txt"); // 文件路径可以实际不存在
		
		// 2.选择流
		BufferedOutputStream os =null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(dest, true));
			
			String msg = "BufferedOutputStream test!\r\n";
			byte[] datas = msg.getBytes(); // 获得字符串的字节码数组（仿造字节流数据）
			os.write(datas, 0, datas.length);
			os.flush(); // 刷新一下，防止内存驻留
			
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
		} catch (IOException e) {
			System.out.println("222");
		} finally {
			// 4.释放资源
			try {
				if(null!=os) {
					os.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
}

