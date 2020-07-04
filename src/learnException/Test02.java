package learnException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试CheckedException可检测异常
 * @author qizidog
 *
 */
public class Test02 {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("./a.txt");
			int ret = reader.read();
			System.out.println((char)ret);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
