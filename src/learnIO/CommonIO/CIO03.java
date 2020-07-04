package learnIO.CommonIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

/**
 * @author qizidog
 * @date 2020.04.22
 * 利用FileUtils将数据写入到文件
 */
public class CIO03 {
    public static void main(String[] args) {
        // 字符串写入到文件
        try {
            FileUtils.write(new File("src/learnIO/CIO03.txt"), "锄禾日当午\r\n", "utf8");
            FileUtils.write(new File("src/learnIO/CIO03.txt"), "汗滴禾下土\r\n", "utf8", true); // 追加写入
            FileUtils.writeStringToFile(new File("src/learnIO/CIO03.txt"), "谁知盘中餐\r\n", "utf8", true); // 和上一句一样的效果
            FileUtils.writeByteArrayToFile(new File("src/learnIO/CIO03.txt"), "粒粒皆辛苦\r\n".getBytes("utf8"), true); // 如果getBytes不指定字符集，将使用项目字符集，可能无法识别
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  // 覆盖写入
        
        // 容器写入到文件
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("lalaohhlala");
        arr.add("nononononoohh");
        arr.add("hey");
        arr.add("lalaohhlala");
        try {
            FileUtils.writeLines(new File("src/learnIO/CIO03.txt"), 
                                "utf8", arr, "**", true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
