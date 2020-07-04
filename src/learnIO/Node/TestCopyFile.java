package learnIO.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 拷贝一个图片文件
 * @author qizidog
 *
 */
public class TestCopyFile {
	public static void main(String[] args) {
		copy_f();
	}
	
	public static void copy_f() {
		File f0 = new File("");
		File f1 = new File(f0.getAbsoluteFile(), "image/net.png");//"src/learnIO/input.txt");
		File f2 = new File(f0.getAbsoluteFile(), "src/learnIO/copyedPic.png");//copyedFile.txt");
		System.out.println(f1.exists()+"  "+f2.exists());
		
		InputStream is = null;
		OutputStream os = null;
		
		
		try {
			is = new FileInputStream(f1);
			os = new FileOutputStream(f2, false); //true);
			
			int len = -1;
			byte[] temp = new byte[1024];
			while((len = is.read(temp))!=-1) {
				System.out.println(new String(temp, 0, len, "utf8"));
				os.write(temp, 0, len);
//				os.write(temp);
				os.flush();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 先打开的后关闭
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
			
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			}
		}
	}
}
