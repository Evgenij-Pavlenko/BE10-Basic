package HW01052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HW01052020.Combination.combination;
import static org.junit.Assert.assertEquals;

public class CombinationTest {

    @Test
    public void testCombinationInt() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3);
        Collections.addAll(list2, 4, 5, 6);
        List<Integer> actualList = new ArrayList<>();
        actualList = combination(list1, list2);
        List<Integer> expectionList = new ArrayList<>();
        Collections.addAll(expectionList, 1, 2, 3, 4, 5, 6);
        assertEquals("size", expectionList.size(), actualList.size());
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectionList.get(i), actualList.get(i));
        }
    }

    @Test
    public void testCombinationString() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list1, "aa", "bb", "cc");
        Collections.addAll(list2, "dd", "ee", "ff");
        List<String> actualList = new ArrayList<>();
        actualList = combination(list1, list2);
        List<String> expectionList = new ArrayList<>();
        Collections.addAll(expectionList, "aa", "bb", "cc", "dd", "ee", "ff");
        assertEquals("size", expectionList.size(), actualList.size());
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectionList.get(i), actualList.get(i));
        }
    }
}
