package HW01052020;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static HW01052020.Names.without4;
import static org.junit.Assert.assertEquals;

public class NamesTest {
    @Test
    public void testWithout4() {
        List<String> myList = new LinkedList<>();
        Collections.addAll(myList, "Ivan", "Maria", "Stephan", "John", "Amalia");
        myList = without4(myList);
        List<String> expectedList = new LinkedList<>();
        Collections.addAll(expectedList,"Maria", "Stephan", "Amalia");
        assertEquals(3, myList.size());
        for (int i = 0; i < myList.size(); i++) {
            assertEquals(expectedList.get(i), myList.get(i));
        }
    }
}
