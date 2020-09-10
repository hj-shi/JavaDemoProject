package linkedHashMap;

import javax.swing.text.Style;
import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        Map<String, String> hashMap = new HashMap<>();
//        hashMap.put("name1", "tom1");
//        hashMap.put("name2", "tom2");
//        hashMap.put("name3", "tom3");
//
//        Set<Map.Entry<String, String>> set = hashMap.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            HashMap.Entry entry = iterator.next();
//            String key = (String) entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("key: " + key  + ", value: " + value);
//        }

        // 第三个参数用于指定 accessOrder 值，表示按访问顺序排序
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", "tom1");
        linkedHashMap.put("name2", "tom2");
        linkedHashMap.put("name3", "tom3");

        System.out.println("开始时顺序");

        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key: " + key  + ", value: " + value);
        }

        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");

        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key2: " + key  + ", value2: " + value);
        }
//        for (Map.Entry<String, String> entry : set2) {
//            String key = (String) entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("key2: " + key  + ", value2: " + value);
//        }

        Map<String, String> hashMap = new HashMap<>(100, 0.75f);
        hashMap.put("hah", "test");
        hashMap.put("hah2", "test2");

    }

}
