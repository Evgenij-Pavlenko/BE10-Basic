package HW09052020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Дан список имен, где некоторые имена повторяются. Написать функцию,
 * которая по имени вернет количество вхождений этого имени в список.
 */
public class NameCount {

    public static Map<String, Integer> nameCount(List<String> list, String str) {
        Map<String, Integer> ret = new HashMap<>();
        for (String s : list) {
            if (str.equals(s)) {
                if (ret.containsKey(s)) {
                    //увеличение value на 1
                    ret.put(s, ret.get(s) + 1);
                }else{
                    ret.put(s, 1);
                }
            }
        }
        return ret;
    }
}
