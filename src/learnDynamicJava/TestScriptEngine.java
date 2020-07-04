package learnDynamicJava;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author qizidog
 * @date 2020.05.23
 * 测试脚本引擎执行javascript代码
 */
public class TestScriptEngine {
    public static void main(String[] args) throws Exception {
        // 获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        
        // 定义变量，存储到引擎的上下文中
        String str = "var user = {name:'gaoqizi', age:18, schools:['swjtu', '北京尚学堂']};";
        str += "print(user.name);";
        engine.put("msg", "qizidog is a good man");
        
        // 执行脚本
        engine.eval(str);
        System.out.println(engine.get("msg"));
        engine.eval("msg = 'sxt is a good school';");
        System.out.println(engine.get("msg"));
        
        System.out.println("=======================================");
        
        // 定义函数
        engine.eval("function add(a,b){var sum = a+b; return sum;}");
        // 执行js函数
        Invocable jsInvoke = (Invocable) engine;
        Object ret = jsInvoke.invokeFunction("add", 13, 20);
        Object ret2 = jsInvoke.invokeFunction("add", new Object[] {13, 20});
        System.out.println(ret+" = "+ret2);
        
        
        // java使用js脚本导入其他java包，使用其他包中的java类，最后再转换成java变量(更深入内容自学Rhino)
        String jsCode = "var list=java.util.Arrays.asList([\"北大\", \"清华\"]);";
        engine.eval(jsCode);
        List<String> list2 = (List<String>)engine.get("list");
        for (String string : list2) {
            System.out.println(string);
        }
        
        System.out.println("=======================================");
        
        // 执行写好的js文件
        URL url = TestScriptEngine.class.getClassLoader().getResource("learnDynamicJava/jstest.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();
    }
}
