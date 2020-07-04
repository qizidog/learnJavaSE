package learnIO.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流操作步骤：
 * 1.创建源
 * 2.选择流
 * 3.操作（读取内容）
 * 4.释放资源
 * @author qizidog
 *
 */

public class TestFileInputStream {
	public static void main(String[] args) {
//		practice();
//		practice2();
//		practice3();
		readFlush();
	}
	
	static void practice() {
		// 1.创建源
		File file = new File("");
		file = new File(file.getAbsoluteFile(), "/src/learnIO/abc.txt");
		System.out.println(file+" file exist:"+file.exists());
		
		// 2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			
			// 3.操作（逐个读取）  
			/*
			 * int data1 = is.read(); // 第一个数据 h int data2 = is.read(); int data3 =
			 * is.read(); int data4 = is.read(); int data5 = is.read();
			 * System.out.println((char)data1); // q System.out.println((char)data2); // i
			 * System.out.println(data3); // 13 归位符 System.out.println(data4); // 10 换行符
			 * System.out.println(data5); // -1 没有读取到数据，文件末尾返回-1
			 */		
			
			int temp;
			while((temp = is.read())!=-1) {
				System.out.println((char)temp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 4.释放资源
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static void practice2() {
		File file = new File("");
		file = new File(file.getAbsolutePath(), "src/learnIO/abcc.txt");
		System.out.println(file.exists());
		
		InputStream is = null;
		try {
			is = new FileInputStream(file);  // 如果file不存在，这里会报IOException
			int temp;
			while((temp = is.read())!=-1) {
				System.out.println(temp);
			}
		}catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}catch(IOException e){
			System.out.println("IOException");
		}finally {
			try {
				if(is!=null) {
					is.close();
				}else {
					System.out.println("the value of is "+is+", so it need not to close.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void practice3() {
		File file = new File("");
		file = new File(file.getAbsoluteFile(), "/src/learnIO/abc.txt");
		System.out.println(file.exists());
		
		FileInputStream is = null;
		StringBuilder sb = new StringBuilder("[");
		try {
			is = new FileInputStream(file);
			int temp;
			while((temp=is.read())!=-1) {
				sb.append(/* (char) */temp+",");
			}
			sb.setCharAt(sb.length()-1, ']');
			System.out.println(sb);
		}catch(FileNotFoundException e){
			System.out.println("file not found.");
		}catch(IOException e) {
			System.out.println("something wrong while file reading.");
		}finally {
			if(is!=null) {
				try {
					is.close();
				}catch (IOException e) {
					System.out.println("close file failed.");
				}
			}
		}
		
	}
	
	static void readFlush() {
		File file = new File("");
		file = new File(file.getAbsoluteFile(), "src/learnIO/input.txt");
		System.out.println(file.exists());
		
		FileInputStream is = null;
		int len = -1;
		byte[] flush = new byte[1024]; // 这里数组长度如果过小可能造成解码乱码
		try {
			is = new FileInputStream(file);
			
			// read into byte[]
			while((len=is.read(flush))!=-1) {
				System.out.println(new String(flush, 0, len,"utf8")); // 指定使用的解码方式
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("111");
		}catch (IOException e) {
			System.out.println("222");
		}finally {
			try {
				if(is!=null) {
					is.close();
				}
			}catch (IOException e) {
				System.out.println("333");
			}
		}
	}
	
	
}
