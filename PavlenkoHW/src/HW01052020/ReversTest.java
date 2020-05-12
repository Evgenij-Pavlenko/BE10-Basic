package HW01052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HW01052020.Revers.reversList;
import static org.junit.Assert.assertEquals;

public class ReversTest {

    @Test
    public void testReversList() {
        List list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        List actualList = reversList(list);
        List expectedList = new ArrayList();
        Collections.addAll(expectedList, 5, 4, 3, 2, 1);
        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }

    }
}
