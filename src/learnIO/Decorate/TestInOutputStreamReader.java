package learnIO.Decorate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
/**
 * 转换流： InputStreamReader和OutputStreamWriter
 * 1、以字符集的形式操作字节流（纯文本）
 * 2、指定字符集
 * @author qizidog
 *
 */
public class TestInOutputStreamReader {
	public static void main(String[] args) {
//		keyboard();
//		url1();
//		url2();
		url3();
	}
	
	public static void keyboard() {
		// 操作System.in和 System.out
		// 在转换流的外面套了一个缓冲流，提高处理效率
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
			
			String msg="";
			while(!msg.equals("exit")) {
				msg = reader.readLine(); // 读取
				writer.write(msg); // 写出
				writer.newLine();  // 换行
				writer.flush();  // 如果不flush，则会在达到一定规模的缓存大小后，再输出
			}
			
		}catch (IOException e) {
			System.out.println("操作异常");
		}
		
	}
	
	public static void url1() { // 存在中文乱码问题
		// 操作网络流，下载百度主页源码
		try(InputStream is = new URL("http://www.baidu.com").openStream()){ // 网络 节点 字节 流
			int temp;
			while((temp = is.read())!=-1) {
				System.out.print((char)temp);
			}
		} catch(IOException e) {
			System.out.println("出了点问题");
		}
	}
	
	public static void url2() {  // 套一个inputStreamReader解决中文乱码问题
		try(InputStreamReader is = 
				new InputStreamReader(
					new URL("http://www.baidu.com").openStream(), "utf8")){ // 网络 节点 字节 流
			int temp;
			while((temp = is.read())!=-1) {
				System.out.print((char)temp);
			}
		} catch(IOException e) {
			System.out.println("出了点问题");
		}
	}
	
	public static void url3() { // 加上一个文件输出流，并套上缓冲流
		try(BufferedReader reader = 
		    new BufferedReader(
				new InputStreamReader(
					new URL("http://www.baidu.com").openStream(), "utf8")); // 指定源文件的字符集
	        BufferedWriter writer = 
	        new BufferedWriter(
	            new OutputStreamWriter(
	                new FileOutputStream("src/learnIO/baidu.html"), "gbk"))){ // 指定保存文件的字符集
			
			String line = null;
			while ((line=reader.readLine())!=null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
