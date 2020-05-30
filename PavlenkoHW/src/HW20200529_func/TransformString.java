package HW20200529_func;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * //"abc defG ikl" -> "ABC defG IKL"
 * // length == 3 -> toUpperCase
 */
public class TransformString {
    public static String transform(String s) {
        String ret = "";
        String[] splitString = s.split(" ");
        Predicate<String> pr = p -> p.length() == 3;
        Function<String, String> fn = f -> f.toUpperCase();
        for (int i = 0; i < splitString.length; i++) {
            if (pr.test(splitString[i])) {
                splitString[i] = fn.apply(splitString[i]);
            }
        }
        ret = String.join(" ", splitString);
        return ret;
    }
}
