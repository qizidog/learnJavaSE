package WriteServer.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qizidog
 * @date 2020.05.19
 * 封装请求协议：获取method，uri及请求参数
 */
public class Request {
    private InputStream is;
    private String requestInfo;  // 请求的信息
    private String method;  // 请求的方式：get  post
    private String uri;  // 统一资源标志符
    private String queryStr;  // 请求的参数
    private Map<String, List<String>> parameterMap;

    
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }
    
    public Request(InputStream is) {
        this.is = is;
        this.parameterMap = new HashMap<String, List<String>>();
        
        // 得到所有的请求信息
        byte[] datas = new byte[1024*1024*10];  // 用来读取请求的容器，为了方便做大一点
        int len;
        try {
            len = is.read(datas);
            if(len!=-1) {
                requestInfo = new String(datas, 0, len, "utf8");
            }else {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        // 解析字符串
        parseRequestInfo();
        
        // 处理请求参数为map
        convertMap();
    }
    
    // 处理中文转码
    private String decode(String value, String enc) {
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private void parseRequestInfo() {  // 解析字符串
//        System.out.println("----开始分解----");
//        System.out.println(requestInfo);
        // 1 获取请求方式（开头---第一个/）
        this.method = requestInfo.substring(0, requestInfo.indexOf('/')).toLowerCase().trim();
        // 2 获取请求url（第一个/---HTTP/）
        int startIdx = this.requestInfo.indexOf('/')+1;
        int endIdx = this.requestInfo.indexOf("HTTP/");
        this.uri = this.requestInfo.substring(startIdx, endIdx).trim();
        int queryIdx = this.uri.indexOf('?');
        if (queryIdx>=0) {
            String[] urlArray = this.uri.split("\\?");
            this.uri = urlArray[0].trim();
            this.queryStr = urlArray[1];
        }
        
        // 3 获取请求参数（如果是get，则为queryStr(已获得)；如果是post，则可能在请求体里面）
        if(method.equals("post")) {
            String temp = this.requestInfo.substring(this.requestInfo.lastIndexOf("\r\n")).trim();
            if(null==queryStr) {
                queryStr = temp;
                
            }else {
                queryStr += ('&'+temp);
            }
        }
        this.queryStr = this.queryStr==null?"":this.queryStr.trim();
//        System.out.println(method+"-->"+uri+"-->"+queryStr);
    }
    
    private void convertMap() {  // 处理请求参数为map
        // fav=1&fav=2&uname=qizidog&age=18&others=
        String[] keyValues = this.queryStr.split("&");
        for (String item : keyValues) {
            String[] temp = item.split("=");
            temp = Arrays.copyOf(temp, 2);  // 拷贝一次，可以解决others=这种等号后为空的麻烦
            ArrayList<String> tempList = new ArrayList<String>();
            String key = temp[0];
            String value = temp[1]==null?null:decode(temp[1], "utf8");
            if(this.parameterMap.containsKey(key)) {
                tempList = (ArrayList<String>) this.parameterMap.get(key);
                tempList.add(value);
                this.parameterMap.put(key, tempList);
            }else {
                tempList.add(value);
                this.parameterMap.put(key, tempList);
            }
        }
    }
    
    /*
     * 返回一个key的所有值
     */
    public String[] getParameterValues(String key){
        List<String> valueslist = this.parameterMap.get(key);
        if(null==valueslist || valueslist.size()<1) {
            return null;
        }
        return valueslist.toArray(new String[0]);  // 考虑到后面的学习以及基本习惯，这里返回数组而不是list
    }
    
    /*
     * 返回一个key的一个值
     */
    public String getParameterValue(String key) {
        String[] values = this.getParameterValues(key);
        return values==null?null:values[0];  // 一种良好的习惯，虽然values可能按常理不会出现null值，但一旦出现values[0]则会报错，故这里避免
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getQueryStr() {
        return queryStr;
    }
    
    
}
