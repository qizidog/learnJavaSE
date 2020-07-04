package learnIO.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class TestFileWriter {
	public static void main(String[] args) {
		writer();
		
	}
	
	public static void writer() {
		File f = new File("");
		f = new File(f.getAbsolutePath(), "/src/learnIO/writer.txt");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
		
		Writer wt = null;
		char[] datas = null;
		datas = "lsjdkl\nasjdew设计费ndl,d阿g里\n斯顿积分\r\n".toCharArray();
		
		try {
			wt = new FileWriter(f);
			
			System.out.println(new String(datas));

			wt.write(datas);  // 写出的文件字符集和项目字符集一致
			wt.append(new String("sldjl熟练度呢落实到积分\r\n")).append("塞尔达传说 旷野之息\r\n");
			
			wt.flush();
			
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
			if (wt!=null) {
				try {
					wt.close();
				} catch (IOException e2) {
				}
			}
		}
	}
}
