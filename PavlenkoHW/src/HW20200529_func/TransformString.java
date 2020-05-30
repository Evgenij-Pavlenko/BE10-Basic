package HW20200529_func;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * //"abc defG ikl" -> "ABC defG IKL"
 * // length == 3 -> toUpperCase
 */
public class TransformString {
    public static String transform(String s, Predicate<String> p, Function<String, String> f) {
        String ret = "";
        String[] splitString = s.split(" ");
        for (int i = 0; i < splitString.length; i++) {
            if (p.test(splitString[i])) {
                splitString[i] = f.apply(splitString[i]);
            }
        }
        ret = String.join(" ", splitString);
        return ret;
    }
}
