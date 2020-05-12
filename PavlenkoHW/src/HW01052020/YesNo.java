package HW01052020;

import java.util.LinkedList;
import java.util.List;

/**
 * 3. Есть два списка одинаковой длины с числами. Написать функцию, которая
 * вернет список с элементами Yes или No, где значение на i-том месте зависит от
 * того, равны ли элементы двух списков под номером i. Например, {1, 2, 3, 4} и {5,
 * 2, 3, 8} вернет {No, Yes, Yes, No}
 */
public class YesNo {
    public static List<String> yesNoMethod(List list1, List list2) {
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                ret.add("Yes");
            } else {
                ret.add("No");
            }
        }
        return ret;
    }
}
