package learnDynamicJava;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;

/**
 * @author qizidog
 * @date 2020.05.24
 * 测试使用javassist生成一个新的类
 * 常用的字节码处理三方包包括：BCEL、ASM、CGLIB、Javassist
 */
public class JavassistDemo01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();  // 获得类池
        CtClass cc = pool.makeClass("learnDynamicJava.Emp");  // 创建class(这里写完整的包名)
        
        // 创建属性
        CtField f1 = CtField.make("private int empno;", cc);  // 创建属性empno
        CtField f2 = CtField.make("private String ename;", cc);  // 创建属性ename
        cc.addField(f1);  // 添加属性
        cc.addField(f2);
        
        // 创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return this.empno;}", cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno = empno;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);
        
        // 创建构造器
//        CtNewConstructor.make("public Emp(){}", cc);  // 第一种方法
        CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType,   // 第二种方法
                pool.get("java.lang.String")}, cc);
        constructor.setBody("{this.empno = $1; this.ename=$2;}");  // $1代表第一个参数，$2代表第二个参数
//        constructor.setBody("{this.empno = empno; this.ename=ename;}");
        cc.addConstructor(constructor);
        
        // 将上面构建好的类写入到这个工作空间中（对应目录会出现一个class文件，通过xjad反编译软件可以查看到类的具体内容）
        cc.writeFile("E:/java_files/learnjava/src/");  // 这里写完整的文件的存放路径
        System.out.println("生成成功！");
    }
}


// 上面的方法创建类似于下面这样的类
//class Emp{
//    private int empno;
//    private String ename;
//    public int getEmpno() {
//        return empno;
//    }
//    public void setEmpno(int empno) {
//        this.empno = empno;
//    }
//    public String getEname() {
//        return ename;
//    }
//    public void setEname(String ename) {
//        this.ename = ename;
//    }
//    
//    public Emp() {
//    }
//    
//    public Emp(int empno, String ename) {
//        this.empno = empno;
//        this.ename = ename;
//    }
//}
