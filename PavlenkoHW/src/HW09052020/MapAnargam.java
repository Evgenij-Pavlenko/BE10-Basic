package HW09052020;

import java.util.*;

/**
 * 3. Анаграмма слова x - слово, по длине равное x и состоящее из таких же букв,
 * что и x. Например, слово “vani” является анаграммой слова “ivan”, а слова
 * “naan” и “anan” являются анаграммами слова “anna”. Дан словарь, сожержащий
 * анаграммы, например {“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”}.
 * Написать функцию, которая по слову из словаря вернет все анаграммы этого
 * слова, которые есть в словаре. Например, по слову “ivan” функция вернет
 * {“navi”, “vani”}
 */
public class MapAnargam {

    public static List<String> anagram(List<String> list, String str) {
        Map<String, List<String>> ret = new HashMap<>();
        List<String> value = new ArrayList<>();
        if (list.contains(str)) {
            ret.put(str, value);
        }
//сортировали по возрастанию, если элементы(i) равны - они анаграммы
        for (int i = 0; i < list.size(); i++) {
            String sTemp = list.get(i);
            char[] ch = sTemp.toCharArray();
            Arrays.sort(ch);
            if (str.equals(ch) && !str.equals(sTemp)) {
                ret.get(str).add(sTemp);
            }
        }


        return value;
    }
}
