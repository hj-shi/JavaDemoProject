package hashmap;

import java.util.*;

public class Test {
    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>();
//        map.put("shi", "student");
//
//        System.out.println(map.containsKey("shi"));
//        System.out.println(map.containsKey("other"));
//        System.out.println("=================================");
//
//        System.out.println(map.get("shi"));
//        System.out.println(map.get("other"));
//        System.out.println("=================================");
//
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());
//        System.out.println("=================================");
//
//        System.out.println(map.remove("shi"));
//        System.out.println(map.containsKey("shi"));
//        System.out.println(map.get("shi"));
//        System.out.println(map.isEmpty());
//        System.out.println(map.size());
//        System.out.println("=================================");
//
//        map.put("shi", "coder");
//        System.out.println(map.get("shi"));
//        map.put("shi", "engineer");
//        System.out.println(map.get("shi"));
//        System.out.println("=================================");
//
//        map.put("liao", "student");
//        map.put("xiaohong", "player");
//
//        for (String key : map.keySet()) {
//            System.out.println(key);
//        }
//        System.out.println("=================================");
//
//        for (String value: map.values()) {
//            System.out.println(value);
//        }
//        System.out.println("=================================");
//
//        map.clear();
//        map.put("A", "1");
//        map.put("B", "2");
//        map.put("C", "3");
//        map.put("D", "1");
//        map.put("E", "2");
//        map.put("F", "3");
//        map.put("G", "1");
//        map.put("H", "2");
//        map.put("I", "3");
//        System.out.println(map.size());
//
//        for (Map.Entry<String, String> entry: map.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + ", " + value);
//        }
//        System.out.println("============================");

        Set<String> set = new LinkedHashSet<>();
        set.add("shi");
        set.add("hong");
        set.add("jie");
        System.out.println(set.contains("shi"));

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

//        Map<Person, Integer> vote = new HashMap<>();
//        vote.put(new Person("shi", 18), 1);
//        vote.put(new Person("shi", 18), 2);
//
//        for (Map.Entry<Person, Integer> entry : vote.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        Person person1 = new Person("shi", 20);
//        Person person2 = new Person("shi", 20);
//        boolean bo = person1.equals(person2);
//        System.out.println("equals: " + bo);
//        System.out.println(person1.hashCode());
//        System.out.println(person2.hashCode());
//
//        Map<Person, Integer> vote = new HashMap<>();
//        vote.put(new Person("shi", 18), 1);
//        vote.put(new Person("shi", 18), 2);
//
//        for (Map.Entry<Person, Integer> entry : vote.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


    }
}
