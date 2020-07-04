package learnIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.management.RuntimeErrorException;
import javax.sound.midi.Sequence;

public class TestSplitFile {
    private String inputFile;  // 输入文件路径
    private String saveDir;  // 保存用的文件夹
    private int blockNum; // 分块数量
    private int blockSize;  // 分块大小
    private ArrayList<String> savePaths = new ArrayList<String>();  // 存放保存文件的名字
    
    public TestSplitFile(String inputFile, String saveDir, int blockNum) {
        this.inputFile = inputFile;
        this.saveDir = saveDir;
        this.blockNum = blockNum;
        initPath();  // 
    }
    
    private void initPath() {
        File inputFileF = new File(this.inputFile);
        if(!inputFileF.exists()) {  // 检测源文件目录是否存在
            new RuntimeErrorException(null, "inputFile not exists!");
        }
        File saveDirF = new File(this.saveDir);
        if(!saveDirF.exists()) {  // 检测指定的保存目录是否存在，如果不存在则创建目录
            saveDirF.mkdir();
            System.out.println("successfully created the new dir"+saveDirF);
        }
        
        // 计算各分块大小
        this.blockSize = (int)Math.ceil(1.0*inputFileF.length()/this.blockNum);  // 分块文件的大小
        // 生成保存文件的名字
        for (int i=0; i<this.blockNum; i++) {
//            System.out.println(i);
            this.savePaths.add(this.saveDir+"/part"+i+".block");
        }
    }
    
    public void split() {
        RandomAccessFile raf = null;
        FileOutputStream fos = null;
        try {
            raf = new RandomAccessFile(this.inputFile, "r");  // 其实也可以不用这个类的
            byte[] flush = new byte[this.blockSize];
            int len = -1;
            int i = 0;
//            for(int i=0; i<this.blockNum; i++) {
            while((len=raf.read(flush))!=-1) {
//               len=raf.read(flush);
               fos = new FileOutputStream(this.savePaths.get(i));
               System.out.println(i);
               fos.write(flush);
               fos.flush();
               i++;
               
               // 关闭文件输出流
               if(fos!=null) {
                   try {
                       fos.close();
                   } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
               }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {  // 关闭随机访问流
            if(raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }

    public void concat(String path2save) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path2save, true);
            for(String each:this.savePaths) {
                FileInputStream fis = new FileInputStream(each);
                
                int len = -1;
                byte[] flush = new byte[1024];
                while((len=fis.read(flush))!=-1) {
                    fos.write(flush, 0, len);
                }
                fos.flush();
                if(fis!=null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(null!=fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void concat2(String path2save) {
        FileOutputStream fos = null;
        Vector<InputStream> vi = new Vector<InputStream>();
        SequenceInputStream sis = null;
        try {
            fos = new FileOutputStream(path2save, true);
            for(String each:this.savePaths) {
                vi.add(new FileInputStream(each));
            }
            
            // 把所有的inputstream组成序列输入流
            sis = new SequenceInputStream(vi.elements());
        
            int len = -1;
            byte[] flush = new byte[1024];
            while((len=sis.read(flush))!=-1) {
                fos.write(flush, 0, len);
            }
            fos.flush();
            
            if(sis!=null) {
                try {
                    sis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(null!=fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        TestSplitFile sf = new TestSplitFile("src/learnIO/TestRandomAccessFile.java", "src/learnIO/block", 5);
//        sf.split();
        sf.concat("src/learnIO/block/concat.java");
    }
}
