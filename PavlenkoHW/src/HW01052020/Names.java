package HW01052020;

import java.util.LinkedList;
import java.util.List;

/**
 * 2. Есть список с именами: Ivan, Maria, Stephan, John, Amalia . Написать функцию,
 * которая вернет список, в котором не содержатся имена исходного списка,
 * длиной 4.
 */
public class Names {

    public static List<String> without4(List<String> list){
        // remove faster in LinkedList
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()==4){
                list.remove(i);
            }
        }
        return list;
    }
}
