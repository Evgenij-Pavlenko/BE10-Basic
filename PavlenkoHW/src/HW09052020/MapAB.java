package HW09052020;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Дана Map<String, String> map, написать функцию, которая вернет Мап, такую,
 * если в есходной map есть ключ ‘a’ и ‘b’, то нужно создать новый ключ ‘ab’ с
 * суммой значений от ключей a и b.
 * Примеры:
 * mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
 * mapAB({"a": "Hi"}) → {"a": "Hi"}
 * mapAB({"b": "There"}) → {"b": "There"}
 */
public class MapAB {

    public static Map<String, String> mapAB(Map<String, String> map) {
        Map<String, String> ret = new LinkedHashMap<>();
        if (map.containsKey("a")) {
            ret.put("a", map.get("a"));
        }
        if (map.containsKey("a") && map.containsKey("b")) {
            ret.put("ab", map.get("a") + map.get("b"));
        }
        if (map.containsKey("b")) {
            ret.put("b", map.get("b"));
        }
        return ret;
    }
}
