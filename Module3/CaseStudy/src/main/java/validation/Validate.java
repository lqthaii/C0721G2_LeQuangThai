package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    static private Pattern pattern;
    static private Matcher matcher;
    public static final String REGEX_PHONE = "^0[0-9]{9}$";
    public static final String REGEX_EMAIL = "\\w+@\\w+\\.\\w+";
    public static boolean validate(String input, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
