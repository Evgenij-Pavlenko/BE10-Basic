package HW01052020;

import java.util.LinkedList;
import java.util.List;

/**
 * 7. Есть список с целыми числами. Написать функцию, которая вернет список без
 * элементов, больше заданного.
 */
public class ListBeforeNumber {
    public static List<Integer> beforeNumber(List<Integer> list, int n) {
        List<Integer> retList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= n) {
                retList.add(list.get(i));
            }
        }
        return retList;
    }
}
