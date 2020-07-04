package learnIO.Node;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestPicInAndOut {
	public static void main(String[] args) {
		// 准备图片路径，构建File对象
		File pic = new File("");
		pic = new File(pic.getAbsolutePath(), "/src/learnIO/copyedPic.png");
		System.out.println(pic.exists()+"-->"+pic.getAbsolutePath());
		
		// 图片转存字节数组
		byte[] data =  pic2bytearray(pic);
		System.out.println(data.length);  // 111910
		
		// 字节数组转存图片
		String dest = System.getProperty("user.dir")+"/src/learnIO/copyedPic2.png";
		System.out.println(dest);
		bytearray2pic(data, new File(dest));
		
	}
	
	public static byte[] pic2bytearray(File pic) {
		// 将图片读取到字节数组中

		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		int len = -1;
		byte[] flush = new byte[1024];
		try {
			fis = new FileInputStream(pic);
			baos = new ByteArrayOutputStream();  // 以bytearray的形式输出（到内存）
			while((len=fis.read(flush))!=-1) {
				baos.write(flush, 0, len);
			}
			baos.flush();
			
			return baos.toByteArray();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭字节输入流
			if (fis!=null) {
				try {
					fis.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
			}
		}
		return null;
	}
	
	public static int bytearray2pic(byte[] btarray, File dest) {
		// 字节数组保存成图片文件
		ByteArrayInputStream bais = null;
		FileOutputStream fos = null;
		try {
			int len = -1;
			byte[] flush = new byte[1024];
			
			bais = new ByteArrayInputStream(btarray);  // 以bytearray的形式输入（从内存）
			fos = new FileOutputStream(dest, false);
			while((len=bais.read(flush))!=-1) {
				fos.write(flush);
			}
			fos.flush();
			return 0;  // 保存成功
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos!=null) {
				try {
					fos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return 1;  // 保存出错
	}
	
}
