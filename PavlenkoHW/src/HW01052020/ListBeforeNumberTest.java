package HW01052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HW01052020.ListBeforeNumber.beforeNumber;
import static org.junit.Assert.assertEquals;

public class ListBeforeNumberTest {

    @Test
    public void testBeforeNumber() {
        int number = 3;
        List<Integer> list = new ArrayList();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        List<Integer> actualList = beforeNumber(list, number);
        List<Integer> expectedList = new ArrayList();
        Collections.addAll(expectedList, 1, 2, 3);
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

    @Test
    public void testBeforeNumber1() {
        int number = 5;
        List<Integer> list = new ArrayList();
        Collections.addAll(list, 5, 4, 6, 7, 1);
        List<Integer> actualList = beforeNumber(list, number);
        List<Integer> expectedList = new ArrayList();
        Collections.addAll(expectedList, 5, 4, 1);
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

}
