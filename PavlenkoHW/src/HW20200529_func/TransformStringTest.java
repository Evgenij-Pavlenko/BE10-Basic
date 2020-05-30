package HW20200529_func;

import org.junit.Test;

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
        String actual = transform(s);
        String expected = "ABC defG IKL";
        assertEquals(expected, actual);

    }
}
