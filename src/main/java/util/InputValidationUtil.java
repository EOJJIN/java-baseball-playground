package util;

public class InputValidationUtil {
    public static boolean isNumericAndThreeDigit(String s) {
        return s != null && s.length() == 3 && s.matches("^[0-9]+$");
    }

    public static boolean isOneOrTwo(String s) {
        return s != null && s.matches("^[1-2]{1}$");
    }
}
