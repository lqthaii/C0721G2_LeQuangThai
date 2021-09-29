package _17_string_regex.exercise.classes_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassesValidate {
    private Pattern pattern;
    private Matcher matcher;
    private static final String CLASS_REGEX = "^[CAP]\\d{4}[GHIKLM]$";
    public ClassesValidate() {
        pattern = Pattern.compile(CLASS_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
