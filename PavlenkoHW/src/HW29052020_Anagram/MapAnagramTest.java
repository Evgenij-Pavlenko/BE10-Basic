package HW29052020_Anagram;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapAnagramTest {
    private static String[] words = {"anna", "ivan", "naan", "vani", "piotr", "nana", "navi"};
    /**
     * "anna" -> [anna, naan, nana]
     */
    @Test
    public void testGetAnagrams1(){
        MapAnagram map = new MapAnagram(words);
        List<String> actual = map.getAnagrams("anna");
        List<String> expected = Arrays.asList("anna", "naan", "nana");
        assertEquals(expected, actual);
    }
    /**
     * "ivan" -> [ivan, vani, navi]
     */
    @Test
    public void testGetAnagrams2(){
        MapAnagram map = new MapAnagram(words);
        List<String> actual = map.getAnagrams("ivan");
        List<String> expected = Arrays.asList("ivan", "vani", "navi");
        assertEquals(expected, actual);
    }
}