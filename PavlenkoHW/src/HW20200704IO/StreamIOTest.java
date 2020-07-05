package HW20200704IO;

import org.junit.Test;

import static HW20200704IO.StreamIO.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StreamIOTest {

    String file = "sum.txt";

    @Test
    public void testSumFromFile1(){
        int actual = sumFromFile1(file);
        int expected = 107;
        assertEquals(expected, actual);
    }

    @Test
    public void testSumFromFile2(){
        int actual = sumFromFile2(file);
        int expected = 107;
        assertEquals(expected, actual);
    }

    /*
    вход {“aaa”, “bbbb”, “a”, ‘bb”} , выход {“a”, “bbb”, “aaa”, “bbbb”}
     */
    @Test
    public void testSortedStringArray(){
        String[] strArr = {"aaa", "bbbb", "a", "bb"};
        String[] actual = sortedStringArray(strArr);
        String[] expected = {"a", "bb", "aaa", "bbbb"};
        assertArrayEquals(expected, actual);
    }
}
