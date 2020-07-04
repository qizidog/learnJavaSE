package commonclass.file;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author qizidog
 *
 */
public class PrintFileTree {
	public static void main(String[] args) {
		File file = new File("E:\\java_files\\learnjava\\src\\commonclass");
		printFile(file, 0);
	}
	
	static void printFile(File file, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("   ");
		}
		System.out.print("-");
		System.out.println(file.getName());
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File temp:files) {
				printFile(temp, level+1);
			}
		}
	}
}
