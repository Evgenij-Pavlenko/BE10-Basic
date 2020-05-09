package HW09052020;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Дан массив букв, вернуть мапу Map<String, Boolean> где каждая строка
 * является ключем, а значением true, если строка в массиве больше одного раза
 * и false, если только один раз.
 * Примеры:
 * wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
 * wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
 */
public class MapBoolean {
    // афигеть, все  работает!)) с лямбдами)))
    public static Map<String, Boolean> wordMultiple(String[] arr) {
        Map<String, Boolean> ret = new HashMap<>();
        for (String s : arr) {
            ret.computeIfPresent(s, (key, value) -> true);
            ret.putIfAbsent(s, false);
        }
        return ret;
    }
}
