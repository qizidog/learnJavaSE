package learnIO.Node;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * 1. 封装拷贝
 * 2. 封装释放
 * @author qizidog
 *
 */
public class FileUtils {
	public static void main(String[] args) {
		// 文件到文件
		File in = new File(System.getProperty("user.dir")+"/src/learnIO/input.txt");
		File out = new File(System.getProperty("user.dir")+"/src/learnIO/input-copy.txt");
		
		try {
			copy(new FileInputStream(in), new FileOutputStream(out));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// 文件到字节数组
		ByteArrayOutputStream baos = null;
		byte[] datas = null;
		try {
			copy(new FileInputStream(in), baos=new ByteArrayOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			System.out.println(new String(datas=baos.toByteArray(), "utf8"));  // 显示一下字节数组的内容
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 字节数组到文件
		try {
			copy(new ByteArrayInputStream(datas), 
				 new FileOutputStream(System.getProperty("user.dir")+"/src/learnIO/output-copy.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// 输入输出流的对接
	public static void copy(InputStream is, OutputStream os) {
		int len = -1;
		byte[] flush = new byte[1024];
		
//		try(is;os) {  // try...with resource
////			int len = -1;
////			byte[] flush = new byte[1024];
//			while ((len=is.read(flush))!=-1) {
//				os.write(flush, 0, len);
//			} 
//			os.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 调用封装的close方法来关闭io流
		try {
			while ((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			} 
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			
		} finally {
			close(is, os);
		}
	}
	
	public static void close(Closeable... ios) {  // 可变参数
		for (Closeable io:ios) {
			if(io!=null) {
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
