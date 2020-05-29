package HashMap;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        System.out.println(i.hashCode());
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "s";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        Map map = new HashMap();
        map.put(1, "one");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "ten");
        Set set = map.entrySet();
        System.out.println(map);
        for (Object o : set) {
            System.out.println(o);
        }
        System.out.println(map.get(1));
    }
}
