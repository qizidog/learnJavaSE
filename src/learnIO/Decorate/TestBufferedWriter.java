package learnIO.Decorate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestBufferedWriter {
	public static void main(String[] args) {
		buffer_writer();
	}
	
	public static void buffer_writer() {
		File f = new File("src/learnIO/writer.txt");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
		
		BufferedWriter bw = null;
		char[] datas = null;
		datas = "塞尔达 传说 旷野之息！！！\r\n".toCharArray();
		
		try {
			bw = new BufferedWriter(new FileWriter(f, true));
			
			bw.write(datas);  // 写出的文件字符集和项目字符集一致（也可以直接传入String类型）
			bw.append(new String("BufferedReader中新增的方法newLine可以使用此方法代替换行符"));
			bw.newLine();
			bw.append("开启了新的一行");
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (bw!=null) {
				try {
					bw.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
