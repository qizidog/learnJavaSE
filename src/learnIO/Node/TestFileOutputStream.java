package learnIO.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author qizidog
 *
 */
public class TestFileOutputStream {
	public static void main(String[] args) {
//		practice1();
//		practice2();
//		practice3();
		practice4();
	}
	
	static void practice1() {
		
		// 1.创建源
		File dest = new File("");
		dest = new File(dest.getAbsoluteFile(), "/src/learnIO/output.txt"); // 文件路径可以实际不存在
		
		// 2.选择流
		OutputStream os =null;
		try {
			os = new FileOutputStream(dest, true);  // 是否追加
			
			// 3.写出数据
			/* \r： return 到当前行的最左边。
			 * \n： newline 向下移动一行，并不移动左右。
			 */
			String msg = "IO is so easy\r\n";
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
	
	static void practice2() {
		File file = new File("");
		file = new File(file.getAbsoluteFile(), "/src/learnIO/output.txt");
		
		String str = "qizidog\r\n";
		byte[] b = str.getBytes();
		FileOutputStream os = null;
			try {
				os = new FileOutputStream(file, true);
				os.write(b);
				os.flush();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(os!=null) {
					try {
						os.close();
					} catch (IOException e2) {
					}
				}
			}
			
	}

	static void practice3() {
		File f = new File(System.getProperty("user.dir"));
		f = new File(f, "/src/learnIO/output.txt");
		System.out.println(f+"  "+f.exists());
		
		byte[] b = "long live, friendship!\r\n".getBytes();
		OutputStream os = null;
		try {
			os = new FileOutputStream(f, true);
			
			os.write(b);
			os.flush();
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static void practice4() {
		File file = new File("");
		file = new File(file.getAbsoluteFile(), "/src/learnIO/output.txt");
		
		OutputStream os= null;
		byte[] info = "\r\nasljdlaj\r\n".getBytes();
		try {
			os = new FileOutputStream(file, true);
			
			os.write(info);
			os.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
		}
		
		
	}
}
