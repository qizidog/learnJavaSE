package learnClassLoader;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 注意，只有被同一个类加载器加载的类，才被认为是同一个类
        // 这里必须指定一个不属于System.getProperty("java.class.path")的路径中的class文件来观察
        FileSystemClassLoader loader = new FileSystemClassLoader("E:/java_files/learnjava/image/");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("E:/java_files/learnjava/image/");
        
        Class<?> clz = loader.findClass("Demo01");
        Class<?> clz2 = loader.findClass("Demo01");
        Class<?> clz3 = loader2.findClass("Demo01");
        Class<?> clz4 = new Demo01().getClass();
        
        System.out.println(clz+"-->"+clz.hashCode()+"-->"+clz.getClassLoader());
        System.out.println(clz2+"-->"+clz2.hashCode()+"-->"+clz2.getClassLoader());
        System.out.println(clz3+"-->"+clz3.hashCode()+"-->"+clz3.getClassLoader());
        System.out.println(clz4+"-->"+clz4.hashCode()+"-->"+clz4.getClassLoader());
    }
}
