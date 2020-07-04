package learnIO.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TestFileReader {
	public static void main(String[] args) {
		reader();
	}
	
	public static void reader() {
		File f = new File("");
		f = new File(f.getAbsolutePath(), "/src/learnIO/input.txt");
		System.out.println(f.exists());
		
		Reader reader = null;
		try {
			reader = new FileReader(f);  // 源文件的字符集应该与项目的字符集相同，否则会乱码
			char[] flush = new char[10];
			while(reader.read(flush)!=-1) {
				System.out.println(new String(flush));
			}
			
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
