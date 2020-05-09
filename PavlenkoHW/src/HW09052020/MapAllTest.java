package HW09052020;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static HW09052020.MapAB.mapAB;
import static HW09052020.MapBoolean.wordMultiple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapAllTest {

    // mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
    @Test
    public void testMapAB1() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", "Hi");
        map.put("b", "There");
        Map<String, String> actual = new LinkedHashMap<>(mapAB(map));
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("a", "Hi");
        expected.put("ab", "HiThere");
        expected.put("b", "There");
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }

    //mapAB({"a": "Hi"}) → {"a": "Hi"}
    @Test
    public void testMapAB2() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("a", "Hi");
        Map<String, String> actual = new LinkedHashMap<>(mapAB(map));
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("a", "Hi");
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }

    //mapAB({"b": "There"}) → {"b": "There"}
    @Test
    public void testMapAB3() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("b", "There");
        Map<String, String> actual = new LinkedHashMap<>(mapAB(map));
        Map<String, String> expected = new LinkedHashMap<>();
        expected.put("b", "There");
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }

    @Test
    public void testMapBoolean1() {
        String[] arr = {"a", "b", "a", "c", "b"};
        Map<String, Boolean> actual = wordMultiple(arr);
        Map<String, Boolean> expected = new LinkedHashMap<>();
        expected.put("a", true);
        expected.put("b", true);
        expected.put("c", false);
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }

    @Test
    public void testMapBoolean2() {
        String[] arr = {"c", "b", "a"};
        Map<String, Boolean> actual = wordMultiple(arr);
        Map<String, Boolean> expected = new LinkedHashMap<>();
        expected.put("a", false);
        expected.put("b", false);
        expected.put("c", false);
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }

    @Test
    public void testMapBoolean3() {
        String[] arr = {"c", "c", "c", "c"};
        Map<String, Boolean> actual = wordMultiple(arr);
        Map<String, Boolean> expected = new LinkedHashMap<>();
        expected.put("c", true);
        assertTrue("size", expected.size() == actual.size());
        for (String k : actual.keySet()) {
            assertEquals(expected.get(k), actual.get(k));
        }
    }


}
