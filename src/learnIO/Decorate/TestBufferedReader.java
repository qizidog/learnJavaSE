package learnIO.Decorate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
	public static void main(String[] args) {
		buffer_read();
		
	}
	
	public static void buffer_read() {
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new FileReader("src/learnIO/writer.txt"));
			
//			int ret=-1;
//			char[] flush = new char[10];
			
//			while((ret=br.read(flush))!=-1) {  // 如果read没有读到，则返回-1
//				System.out.println(new String(flush));
//			}
			
			String line = null;
			while((line=br.readLine())!=null) {  // 如果readline没有读到，则返回null
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
