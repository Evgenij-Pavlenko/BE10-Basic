package HW01052020;

import java.util.LinkedList;
import java.util.List;

/**
 * 6. Объединить два списка в один.
 */
public class Combination {
    public static <E> List<E> combination(List<E> list1, List<E> list2) {
        List<E> retList = new LinkedList<>();
        retList.addAll(list1);
        retList.addAll(list2);
        return retList;
    }
}
