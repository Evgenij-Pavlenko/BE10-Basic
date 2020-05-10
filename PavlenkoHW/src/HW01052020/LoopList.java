package HW01052020;

import java.util.Collections;
import java.util.List;

/**
 * 4. Есть два списка с буквами. Определить, является ли один список циклической
 * версией другого. Например, для списков {aa, bb, cc, dd} и {cc, dd, aa, bb}
 * результат будет true, а для {dd, ee, ff} и {dd, ff, ee} - false.
 */
// наверное, есть решение попроще. с "contains(Object o)" тоже много кода выходит((
public class LoopList {
    public static void main(String[] args) {

    }

    public static boolean isLoopList(List<String> list1, List<String> list2) {
        boolean flag = false;
        if (list1.size() == list2.size()) {
            //высисляем размер смещения
            int count = list2.indexOf(list1.get(0));
            System.out.println(count);
            //смещаем. Про rotate() подсмотрел
            Collections.rotate(list2, count);
            //и сравниваем. Удивительно, что не нужно каждый элемент отдельно сравнивать,
            // а у List метод equals уже нормально определен
            flag = list1.equals(list2);
        }
        return flag;
    }
}
