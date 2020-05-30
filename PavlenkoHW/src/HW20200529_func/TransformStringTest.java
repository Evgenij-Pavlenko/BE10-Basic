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
        Predicate<String> prLength3 = p -> p.length() == 3;
        Function<String, String> fToUpperCase = f -> f.toUpperCase();
        String actual = transform(s, prLength3, fToUpperCase);
        String expected = "ABC defG IKL";
        assertEquals(expected, actual);
    }
}
