package HW01052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static HW01052020.YesNo.yesNoMethod;
import static org.junit.Assert.assertEquals;

public class YesNoTest {

    @Test
    public void testYesNoMethod() {
        List<Integer> listI1 = new ArrayList<>();
        List<Integer> listI2 = new ArrayList<>();
        Collections.addAll(listI1, 1, 2, 3, 4);
        Collections.addAll(listI2, 5, 2, 3, 8);
        List<String> actualList = yesNoMethod(listI1, listI2);
        List<String> expectedList = new LinkedList<>();
        Collections.addAll(expectedList, "No", "Yes", "Yes", "No");
        assertEquals("size", expectedList.size(), actualList.size());
        for (int i = 0; i < listI1.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }

    }

}
