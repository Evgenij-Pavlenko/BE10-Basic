package HW29052020_Anagram;


/**
 * /**
 * 3. Анаграмма слова x - слово, по длине равное x и состоящее из таких же букв,	 * 3. Анаграмма слова x - слово, по длине равное x и состоящее из таких же букв,
 * что и x. Например, слово “vani” является анаграммой слова “ivan”, а слова	 * что и x. Например, слово “vani” является анаграммой слова “ivan”, а слова
 * “naan” и “anan” являются анаграммами слова “anna”. Дан словарь, сожержащий	 * “naan” и “anan” являются анаграммами слова “anna”. Дан словарь, сожержащий
 * анаграммы, например {“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”}.	 * анаграммы, например {“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”}.
 * Написать функцию, которая по слову из словаря вернет все анаграммы этого	 * Написать функцию, которая по слову из словаря вернет все анаграммы этого
 * слова, которые есть в словаре. Например, по слову “ivan” функция вернет	 * слова, которые есть в словаре. Например, по слову “ivan” функция вернет
 * {“navi”, “vani”}	 * {“navi”, “vani”}
 */

import java.util.*;

public class MapAnagram {
    private static String[] words = {"anna", "ivan", "naan", "vani", "piotr", "nana", "navi"};
    Map<String, List<String>> mapVoc = new HashMap<>();

    public MapAnagram(String[] voc) {
        populateVoc(voc);
    }
    // 1. create voc from words
    // 2. get list by word

    private void populateVoc(String[] voc) {
        //пороходим весь список
        for (String s : voc) {
            //получаем ключ Мапы в виде String
            String key = sortedString(s);
            mapVoc.putIfAbsent(key, new ArrayList<>());
            mapVoc.get(key).add(s);
            //в таком варианте не работает:
//            voc.computeIfPresent(key, (k,v) -> v.add(s));
        }
    }

    private String sortedString(String string) {
        char[] ch = string.toLowerCase().toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public List<String> getAnagrams(String word) {
        //делаем из word -> key (ключ мапы) и возвращаем список из value
        return mapVoc.get(sortedString(word));
    }

    public static void main(String[] args) {
        MapAnagram mapAnagram = new MapAnagram(words);
        System.out.println(mapAnagram.getAnagrams("anna"));
        System.out.println(mapAnagram.getAnagrams("ivan"));
    }
}
