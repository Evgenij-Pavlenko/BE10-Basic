package HW01052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HW01052020.LoopList.isLoopList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoopListTest {
    @Test
    public void testIsLoopListTrue() {
        List<String> listS1 = new ArrayList<>();
        List<String> listS2 = new ArrayList<>();
        Collections.addAll(listS1, "aa", "bb", "cc", "dd");
        Collections.addAll(listS2, "cc", "dd", "aa", "bb");
        assertTrue(isLoopList(listS1, listS2));
    }

    @Test
    public void testIsLoopListFalse() {
        List<String> listS1 = new ArrayList<>();
        List<String> listS2 = new ArrayList<>();
        Collections.addAll(listS1, "dd", "ee", "ff");
        Collections.addAll(listS2, "dd", "ff", "ee");
        assertFalse(isLoopList(listS1, listS2));
    }

}
