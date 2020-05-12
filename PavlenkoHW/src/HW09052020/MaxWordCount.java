package HW09052020;

import java.util.*;

/**
 * 5. Дан текст, подсчитать, какое слово встречается больше остальных. Слова в
 * предложениях могут разделяться запятыми, точками, пробелами. Предлоги [в,
 * на, из, под] и остальные не учитывать при подсчете.
 */

public class MaxWordCount {

    public static Map<String, Integer> maxWordCount(String str) {
        //Убираем пробелы и знаки припинания. Помещаем отдельные слова в лист
        List<String> listSplit = new LinkedList<>(Arrays.asList(str.split("\\s*(\\s|,|!|\\.)\\s*")));
        Map<String, Integer> ret = new HashMap<>();
        //проходим по листу, и слова с size>3 (не предлоги и т.д.) помещаем в Мап
        //где слово - ключ, знаение - сколько раз встречается
        for (String s : listSplit) {
            if (s.length() > 3) {
                if (ret.containsKey(s)) {
                    //увеличение value на 1
                    ret.put(s, ret.get(s) + 1);
                } else {
                    ret.put(s, 1);
                }
            }
        }
        //находим максимальное значение value и помещаем в entrySet, который и возвращаем в тест или куда надо
        /*
        хотел сначала найти максимальное value, а потом в цикле искать соответствие ключа и вытащить этот сет
        но потом разобрался со вторым аргументом - компаратором(можно отдельный компаратор писать,
         потом вставлять в качестве второго аргумента)
         */
        Map.Entry me = Collections.max(ret.entrySet(), (es1, es2) -> es1.getValue() - es2.getValue());
        ret.clear();
        ret.put((String) me.getKey(), (Integer) me.getValue());
        return ret;
    }
}
