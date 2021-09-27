package _17_string_regex.exercise.number_phone_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberPhone {
    private Pattern pattern;
    private Matcher matcher;
    private static final String NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{1,}\\)$";
    public NumberPhone() {
        pattern = Pattern.compile(NUMBER_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

