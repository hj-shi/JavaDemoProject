package hashmap;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("testObj", new Object());
        hashMap.put("testObj", new Object());
        hashMap.put("testObj", new Object());
        hashMap.put("testObj2", new Object());
        System.out.println("hashMap size: " + hashMap.size());
    }
}
