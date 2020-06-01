package HW20200529_func;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static HW20200529_func.TransformString.transform;
import static org.junit.Assert.assertEquals;

public class TransformStringTest {
    /**
     * //"abc defG ikl" -> "ABC defG IKL"
     * // length == 3 -> toUpperCase
     */
    @Test
    public void testTransform() {
        String s = "abc defG ikl";
        Predicate<String> pred = p -> p.length() == 3;
        Function<String, String> func = f -> f.toUpperCase();
        String actual = transform(s, pred, func);
        String expected = "ABC defG IKL";
        assertEquals(expected, actual);
    }

    /**
     * //"Abc defG ikL" -> "Abc defg ikL"
     * // length == 4 -> toLowerCase
     */
    @Test
    public void testTransform2() {
        String s = "Abc defG ikL";
        Predicate<String> pred = p -> p.length() == 4;
        Function<String, String> func = String::toLowerCase;
        String actual = transform(s, pred, func);
        String expected = "Abc defg ikL";
        assertEquals(expected, actual);
    }

    /**
     * //"abc defG asdfRg ikl" -> "abc defG 6 ikl"
     * // length >5 -> remove
     */
    @Test
    public void testTransform3() {
        String s = "abc defG asdfRg ikl";
        Predicate<String> pred = p -> p.length() > 5;
        Function<String, String> func = f -> String.valueOf(f.length());
        String actual = transform(s, pred, func);
        String expected = "abc defG 6 ikl";
        assertEquals(expected, actual);
    }

    /**
     * //"abc defGa iakl" -> "Abc defGA iAkl"
     * // length == 3 -> toUpperCase
     */
    @Test
    public void testTransform4() {
        String s = "abc defGa iakl";
        Predicate<String> pred = p -> p.contains("a");
        Function<String, String> func = f -> f.replace("a", "A");
        String actual = transform(s, pred, func);
        String expected = "Abc defGA iAkl";
        assertEquals(expected, actual);
    }


}
