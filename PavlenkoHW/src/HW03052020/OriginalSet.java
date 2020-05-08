package HW03052020;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class OriginalSet {

    public static <E> List<E> removeDuplicates(List<E> list){
        List<E> ret = new ArrayList<>();
        Set<E> set = new LinkedHashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        ret.addAll(set);
        return ret;
    }
}
