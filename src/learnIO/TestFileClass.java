package learnIO;

import java.io.File;
import java.io.IOException;

public class TestFileClass {
	public static void main(String[] args) {
//		separator();
//		constructor();
//		filepath();
//		fileexist();
//		create_delete();
		directory();
//		testShowFiles();
	}
	
	static void separator() {
		String path = "E:\\java_files\\learnjava\\image\\ball.png";
		
		System.out.println(path);
		
		// 文件分隔符的使用
		System.out.println(File.separator); // 返回值类型时String
		System.out.println(File.separatorChar); // 返回值类型是Char
		// 1、全部使用"/"符号
		path = "E:/java_files/learnjava/image/ball.png";
		System.out.println(path);

		// 2、使用常量拼接
		path = "E:"+File.separator+"java_files"+File.separator+"learnjava"+
				File.separator+"image"+File.separator+"ball.png";
		System.out.println(path);
		
		// 路径分隔符
		// win中的路径分隔符为;   linux中的路径分隔符为:
		System.out.println(File.pathSeparator); // 返回值类型是String
		System.out.println(File.pathSeparatorChar); // 返回值类型是Char
	}
	
	static void constructor() {
		String path = "E:/java_files/learnjava/image/ball.png";
		System.out.println(path);

		// 构造file对象
		// 1、通过字符串构建
		File src = new File(path);
		System.out.println(src.length());
		
		// 2、通过父路径和子路径拼接
		src = new File("E:/java_files/learnjava/image", "ball.png");
		System.out.println(src.length());
		src = new File("E:/java_files/learnjava", "image/ball.png");
		System.out.println(""+src+"  "+src.length());
		
		// 3、通过父路径的File对象和子路径字符串拼接
		src = new File(new File("E:/java_files/learnjava"), "image/ball.png");
		System.out.println(src);
		
	}
	
	static void filepath() {
		// 相对路径和绝对路径
		System.out.println("user.dir:   "+System.getProperty("user.dir"));
		File file = new File("image");
		System.out.println("name:   "+file.getName());
		System.out.println("parent:   "+file.getParent());
		System.out.println("path:   "+file.getPath());
		System.out.println("absolute path:   "+file.getAbsolutePath());
		System.out.println();
		// 构建一个不存在的文件
		file = new File("lasfjls/sldifjlxt");
		System.out.println("name:   "+file.getName());//获得文件的名字(path中的最后一部分)
		System.out.println("parent:   "+file.getParent());//获得文件所在的目录(path中除了最后一个的前面部分)
		System.out.println("path:   "+file.getPath());//获得文件对象构建时的path
		System.out.println("absolute path:   "+file.getAbsolutePath());//获得拼接而成的绝对路径
		System.out.println("获得父对象:   "+file.getParentFile().getAbsolutePath());
	}
	
	static void fileexist() {
	/*File状态
	 * 	1、不存在
	 *  2、存在
	 *  	文件：isFile
	 *  	文件夹：isDirectory
	 */
		File file = new File("E:\\java_files\\learnjava\\image\\ball.png");
		System.out.println("是否存在"+file.exists());
		System.out.println("是否是文件："+file.isFile());
		System.out.println("是否是文件夹"+new File("E:\\java_files\\learnjava\\image").isDirectory());
		
		if(!file.exists()||file==null) {
			System.out.println("文件不存在");
		}else {
			if(file.isFile()) {
				System.out.println("文件操作");
				System.out.println(file.length()); // 只有文件才有长度
			}else {
				System.out.println("文件夹操作"); // 文件夹的length是0
			}
		}
	}
	
	static void create_delete() {
		File file = new File("E:\\java_files\\learnjava/src/learnIO/test.txt");
		System.out.println("absolute path:"+file.getAbsolutePath());
		System.out.println("file exist:"+file.exists());
		try {
			boolean flag = file.createNewFile(); // 不存在才创建，创建失败返回false
			System.out.println("create new file:"+flag);
			flag = file.delete();
			System.out.println("delete the file:"+flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void directory() {
		// mkdir
		File file = new File("E:\\java_files\\learnjava\\src\\learnIO\\testDir");
		System.out.println(file.getAbsolutePath());
		boolean flag = file.mkdir(); // 创建目录，若目录上级不存在则创建失败
		System.out.println("路径创建："+flag);
		
		// mkdirs
		file = new File("E:\\java_files\\learnjava\\src\\learnIO\\AA/BB/CC");
		flag = file.mkdirs(); // 创建目录，若目录上级不存在，则自动创建上级目录
		System.out.println("路径连续创建："+flag);
		
		// delete dir
		file = new File("E:\\java_files\\learnjava/src/learnIO/AA/BB/CC");
		flag = file.delete();
		System.out.println("delete the directory:"+flag+"\n");
		
		// list
		file = new File("E:/java_files/learnjava/src/learnIO");
		String[] list = file.list();  // 获得子文件的String路径
		for (String each : list) {
			System.out.println(each);
		}
		System.out.println();
		
		// listFiles
		File[] listFiles = file.listFiles();  // 获得子文件的file对象
		for (File f : listFiles) {
			System.out.println(f.getName());
		}
		System.out.println();
		
		// 所有盘符
		File[] roots = File.listRoots(); // 是一个静态方法
		for (File f : roots) {
			System.out.println(f);
		}
		System.out.println("当前分区的剩余空间："+file.getFreeSpace());
		System.out.println("当前分区的可用空间："+file.getUsableSpace());
		System.out.println("当前分区的总空间："+file.getTotalSpace());
	}

	static void testShowFiles() {
		File file = new File("src/learnIO");
		System.out.println("file path:"+file.getAbsolutePath()+"\n");
		show_files(file.getAbsoluteFile(), 0);
		countDirLen(file);
		System.out.println("文件夹占用空间大小："+length+"；文件数目："+file_num+"；文件夹数目："+dir_num);
	}
	
	// print files tree
	static void show_files(File file, int level) {
		if(file!=null && file.exists()) {
			for (int i = 0; i < level; i++) {
				System.out.print("-");
			}
			if(file.isFile()) {
				System.out.println(file.getName());
			}else {
				System.out.println(file.getName());
				for(File each:file.listFiles()) {
					show_files(each, 1+level);
				}
			}
		}else {
			System.out.println("file is not exist!");
		}
	}
	
	// count files values
	private static Long length = 0L;
	private static int file_num=0;
	private static int dir_num=0;
	static void countDirLen(File file) {
		if(file.exists() && file!=null) {
			if(file.isDirectory()) {
				for(File f:file.listFiles()) {
					countDirLen(f);
				}
				dir_num++;
			}else {
				length+=file.length();
				file_num++;
			}
		}else {
			System.out.println("file is not exist");
		}
	}
}

