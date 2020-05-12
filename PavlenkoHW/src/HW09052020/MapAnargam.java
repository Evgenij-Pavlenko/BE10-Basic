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

    String[] words = {"anna", "ivan", "naan", "vani", "piotr", "nana", "navi"};
    Map<String, List<String>> voc = new HashMap<>();

    public MapAnargam() {
        populateVoc();
    }
    // 1. create voc from words
    // 2. get list by word

    public void populateVoc() {
    //words -> voc
    // ivan navi navi -> ainv

        //пороходим весь список
        for (String s : words) {
            //сортируем буквы в слове по алфавиту
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            //получаем ключ Мапы в виде String
            String key = String.valueOf(ch);

            voc.putIfAbsent(key, new ArrayList<>());
            voc.get(key).add(s);

            //в таком варианте не работает:
//            voc.computeIfPresent(key, (k,v) -> v.add(s));
        }
    }

    public List<String> getAnagrams(String word) {
        //делаем из word -> key (ключ мапы)
        char[] ch = word.toLowerCase().toCharArray();
        Arrays.sort(ch);
        return voc.get(String.valueOf(ch));
        //а такая конструкция не работает, видимо из-за последовательности операций:
//        return voc.get(String.valueOf(Arrays.sort(word.toLowerCase().toCharArray())));
    }

    public static void main(String[] args) {
        MapAnargam m = new MapAnargam();
        System.out.println(m.getAnagrams("anna"));
    }
}
