package learnClassLoader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author qizidog
 * @date 2020.05.25
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader{
    private String rootDir;
    
    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("-----------------------------");
        // 先检查一下类是否已经被加载了
        Class<?> c = findLoadedClass(name);
        if(c!=null) {
            System.out.println("该class已经被加载过了，不再重复加载");
            return c;
        }else {  // 如果没有被加载，则通过父类加载
            try {
                // 父类是AppClassLoader
                // (因为项目属性里面设置了bin目录的class都是AppClassLoader来加载)
                ClassLoader parent = this.getParent();  //$AppClassLoader
//                ClassLoader parent = this.getParent().getParent();  //$ExtClassLoader
                System.out.println("parent: "+parent);
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }
            if(c!=null) {  // 如果父类加载到了
                System.out.println("被父类截胡了！！！");
                return c;
            }else {  // 如果父类没有加载到，则自己加载
                byte[] classData = getClassData(name);
                if(classData==null) {  // 如果自己没有加载到，报错
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name, classData, 0, classData.length);
                    System.out.println("自己定义的loader成功了");
                    return c;
                }
            }
        }
        
    }
    
    private byte[] getClassData(String classname) {  // com.bjsxt.test.User
        String filePath = rootDir + "/" + classname.replace('.', '/')+".class";
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;
        int len = -1;
        byte[] flush = new byte[1024];
        try {
            bis = new BufferedInputStream(
                            new FileInputStream(filePath));
            bos = new ByteArrayOutputStream();
            while((len=bis.read(flush))!=-1) {
                bos.write(flush, 0, len);
            }
            return bos.toByteArray();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
}
