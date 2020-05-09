package HW01052020;

import java.util.Collections;
import java.util.List;

/**
 * 5. Написать функцию, которая реверсирует список, возвращает список элементов
 * в обратном порядке. {1, 2, 3, 4, 5} -> {5, 4, 3, 2, 1}
 */
public class Revers {

    public static List reversList(List list) {
//        LinkedList retList = new LinkedList();
        Collections.reverse(list);
//        for (int i = 0; i < list.size(); i++) {
//            retList.addFirst(list.get(i));
//        }
        return list;
    }
}
