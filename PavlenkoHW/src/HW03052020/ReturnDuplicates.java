package HW03052020;

import java.util.*;

public class ReturnDuplicates {

    public static <E> List<E> getDuplicates(List<E> list) {
        List<E> ret = new ArrayList<>();
        Set<E> set = new HashSet<>();
        set.addAll(list);
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            E e = it.next();
            for (int j = set.size(); j < list.size(); j++) {
                if (e.equals(list.get(j))) {
                    ret.add(e);
                }
            }
        }
        // быстро работает, но порядок возвращаемого писка не тот
//        for (int i = 0; i < list.size(); i++) {
//            if (!set.add(list.get(i))) {
//                ret.add(list.get(i));
//            }
//        }

        return ret;
    }
}
