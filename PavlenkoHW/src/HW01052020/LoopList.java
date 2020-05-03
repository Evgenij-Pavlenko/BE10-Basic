package HW01052020;

import java.util.List;

/**
 * 4. Есть два списка с буквами. Определить, является ли один список циклической
 * версией другого. Например, для списков {aa, bb, cc, dd} и {cc, dd, aa, bb}
 * результат будет true, а для {dd, ee, ff} и {dd, ff, ee} - false.
 */
// наверное, есть решение попроще. с "contains(Object o)" тоже много кода выходит((
public class LoopList {
    public static boolean isLoopList(List list1, List list2) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (i == list1.size() - 1) { // если во втором листе элементы идут подряд, а в первом - это первый и последний элемент
                    if (list1.get(i).equals(list2.get(j)) && list1.get(0).equals(list2.get(j + 1))) {
                        count++;
                    }
                } else if (j == list2.size() - 1) { // так же и для первого листа
                    if (list1.get(i).equals(list2.get(j)) && list1.get(i + 1).equals(list2.get(0))) {
                        count++;
                    }
                } else { // нормальное сравнение элементов в середине списка
                    if (list1.get(i).equals(list2.get(j)) && list1.get(i + 1).equals(list2.get(j + 1))) {
                        count++;
                    }
                }
            }
        }
        return count == list1.size();
    }
}
