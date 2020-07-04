package learnDynamicJava;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.bytecode.ByteArray;
import learnException.Test01;

/**
 * @author qizidog
 * @date 2020.05.24
 * 测试javassist的API
 */
public class JavassistDemo02 {
    public static void main(String[] args) throws Exception {
//        test01();
//        test02();
//        test03();
        test04();
        
    }
    
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("learnDynamicJava.Emp");
        
        byte[] bytes = cc.toBytecode();  // 转换成字节码
        System.out.println(Arrays.toString(bytes));
        
        System.out.println("类名："+cc.getName());  // 获得类名
        System.out.println("简要类名："+cc.getSimpleName());  // 获得简要类名
        System.out.println("父类："+cc.getSuperclass());  // 获得父类
        System.out.println("接口数组："+cc.getInterfaces());  // 获得接口数组
    }
    
    
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("learnDynamicJava.Emp");
        
        // 三种创建  方法  的途径
        // 方法1
//        CtMethod m = CtNewMethod.make("public int add(int a, int b){return a+b;}", cc);
        // 方法2
//        CtMethod m = CtMethod.make("public int add(int a, int b){return a+b;}", cc);
        // 方法3
        CtMethod m = new CtMethod(CtClass.intType, "add", 
                new CtClass[] {CtClass.intType, CtClass.intType}, cc);
        m.setModifiers(Modifier.PUBLIC);  // 设置访问限制符
        m.setBody("{System.out.println(\"从前有只启子狗...\"); return $1+$2;}");
        cc.addMethod(m);
        
        CtConstructor constructor = new CtConstructor(new CtClass[] {}, cc);  // 增加一个无参构造器
        constructor.setBody(null);
        cc.addConstructor(constructor);
        
        
        // 通过反射调用新生成的方法
        Class clz = cc.toClass();  // 将Ctclass转换为java的Class对象
        Object obj = clz.newInstance();  // 调用Emp的无参构造器创建实例对象
        for(Method mt : clz.getDeclaredMethods()) {  // 查看一下刚刚的方法加进去了没有
            System.out.println(mt);
        }
        Method mth = clz.getDeclaredMethod("add", int.class, int.class);
        Object ret = mth.invoke(obj, 12345, 54321);
        System.out.println("计算结果是："+ret);
    }

    
    public static void test03() throws Exception {
        // 获取已有的方法并做一定的修改
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("learnDynamicJava.Emp");
        // 获取
        CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[] {CtClass.intType});  // 获取指定的方法
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAfter("System.out.println(\"end!!!\");");
        // 反射调用
        Class clz = cc.toClass();
        Object obj = clz.newInstance();
        Method mth = clz.getDeclaredMethod("sayHello", int.class);
        mth.invoke(obj, 321);
    }
    
    public static void test04() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("learnDynamicJava.emp");
        
        // 创建属性
//        CtField f1 = CtField.make("private int empno;", cc);  // 创建属性empno
        CtField f2 = new CtField(CtClass.intType, "empid", cc);  // 第二种创建方法
        f2.setModifiers(Modifier.PRIVATE);
        cc.addField(f2);
        
//        CtField f3 = cc.getDeclaredField("empid");  // 获取指定的属性
        cc.addMethod(CtNewMethod.getter("getEmpid", f2));  // 添加f2属性的get方法
        cc.addMethod(CtNewMethod.getter("setEmpid", f2));  // 添加f2属性的set方法
    }
}
















