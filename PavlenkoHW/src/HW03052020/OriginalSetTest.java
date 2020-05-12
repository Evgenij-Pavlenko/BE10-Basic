package HW03052020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HW03052020.OriginalSet.removeDuplicates;
import static HW03052020.ReturnDuplicates.getDuplicates;
import static org.junit.Assert.assertEquals;

public class OriginalSetTest {
    @Test
    public void testOriginalSet(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        List<String> actualList = removeDuplicates(list);

        List<String> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, "Ivan", "Maria", "Piotr", "Anna");
        for (int i = 0; i < expectedList.size(); i++) {
        assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

    @Test
    public void testReturnDuplicates(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan");

        List<String> actualList = getDuplicates(list);

        List<String> expectedList = new ArrayList<>();
        Collections.addAll(expectedList, "Ivan", "Maria");

        //"Maria", "Ivan" - проходит тест. Зависит от hash
        for (int i = 0; i < actualList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }
}
