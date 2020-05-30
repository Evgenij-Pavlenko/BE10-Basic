package HW29052020_Anagram;

import HW09052020.MapAnargam;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapAnagramTest {
    /**
     * "anna" -> [anna, naan, nana]
     */
    @Test
    public void testGetAnagrams1(){
        MapAnargam map = new MapAnargam();
        List<String> actual = map.getAnagrams("anna");
        List<String> expected = Arrays.asList("anna", "naan", "nana");
        assertEquals(expected, actual);
    }
    /**
     * "ivan" -> [ivan, vani, navi]
     */
    @Test
    public void testGetAnagrams2(){
        MapAnargam map = new MapAnargam();
        List<String> actual = map.getAnagrams("ivan");
        List<String> expected = Arrays.asList("ivan", "vani", "navi");
        assertEquals(expected, actual);
    }
}
