package commonclass.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;
/**
 * 测试file类的基本用法
 * @author qizidog
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		// 注意！当前目录默认为是当前package的项目路径
		System.out.println(System.getProperty("user.dir"));  // 项目路径
		File f = new File("a.txt");
//		f.renameTo(new File("./aaa.txt"));  // 重命名文件
		
		File file = new File("d:/sxt/douglas/b.txt");
		File dir = file.getParentFile();  // 获得文件所在路径
		System.out.println(dir);
	
		File f2 = new File(System.getProperty("user.dir")+"/b.txt");  // 创建到了项目路径
		f2.createNewFile();  // 创建文件
		System.out.println(f2);
		f2.delete();  // 删除文件
		
		System.out.println("File是否存在："+f.exists());
        System.out.println("File是否是目录："+f.isDirectory());
        System.out.println("File是否是文件："+f.isFile());
        System.out.println("File最后修改时间："+new Date(f.lastModified()));
        System.out.println("File的大小："+f.length());
        System.out.println("File的文件名："+f.getName());
        System.out.println("File的目录路径："+f.getPath());
        System.out.println("File的目录绝对路径："+f.getAbsolutePath());
        
        
//        File f3 = new File("电影/华语/大陆");
//        boolean flag3 = f3.mkdir(); //目录结构中有一个不存在，则不会创建整个目录树
//        System.out.println(flag3);//创建失败
        
//        File f4 = new File("d:/电影/华语/大陆");
//        boolean flag4 = f4.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
//        System.out.println(flag4);//创建成功
	}
}
