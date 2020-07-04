package learnCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * ORM思想的简单实验，用容器存放表格信息
 * @author qizidog
 *
 */
public class TestTable {
	public static void main(String[] args) {
		Map<String, Object> row1 = new HashMap<>();
		row1.put("id", 1001);
		row1.put("name", "张三");
		row1.put("salary", 111);
		row1.put("入职日期", "2019.2.4");
		
		Map<String, Object> row2 = new HashMap<>();
		row2.put("id", 1002);
		row2.put("name", "李四");
		row2.put("salary", 2000);
		row2.put("入职日期", "2014.5.14");

		Map<String, Object> row3 = new HashMap<>();
		row3.put("id", 1002);
		row3.put("name", "王五");
		row3.put("salary", 600);
		row3.put("入职日期", "2016.8.30");
		
		List<Map> table = new ArrayList<Map>();
		table.add(row1);
		table.add(row2);
		table.add(row3);
		
		for (Map row:table) {
//			Set<String> keyset = row.keySet();
//			for(String key:keyset) {
//				System.out.println(key+":"+row.get(key));
//			}
			System.out.println(row.values());
		}
	}
}
