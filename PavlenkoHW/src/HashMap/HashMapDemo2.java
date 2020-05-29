package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo2 {
    public static void main(String[] args) {
        Keys k1 = new Keys(1);
        Keys k2 = new Keys(2);
        Keys k3 = new Keys(3);

        Map<Object, String> map = new HashMap();
        map.put(k1, "one");
        map.put(k3, "three");
        map.put(k2, "two");
        map.put(10, "ten");
        Set set = map.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }
        System.out.println(map);
        System.out.println("Key = k1: " + map.get(k1));
    }
}

class Keys {
    int key;

    public Keys(int key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keys keys = (Keys) o;
        return key == keys.key;
    }

//    @Override
//    public int hashCode() {
//        return 1;
//    }

    @Override
    public String toString() {
        return key + "";
    }
}