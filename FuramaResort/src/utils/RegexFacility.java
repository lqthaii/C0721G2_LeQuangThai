package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFacility {
    private Matcher matcher;
    public static final String ID_VILLA_REGEX = "^SVVL-\\d{4}$";
    public static final String ID_HOUSE_REGEX = "^SVHO-\\d{4}$";
    public static final String ID_ROOM_REGEX = "^SVRO-\\d{4}$";
    public static final String NAME_REGEX = "^[A-Z][a-z1-9]*$";
    public static final String AREA_REGEX = "^[\\d^012]\\d+.\\d+$";
    public static final String COST_REGEX = "^\\d+\\d+$";
    //public static final String QUANLITY_REGEX = "^+[01]\\d$";
    public static final String NUMBER_REGEX = "^+\\d{1,2}$";

    public boolean validate(String value, String regex) {
        matcher = Pattern.compile(regex).matcher(value);
        return matcher.matches();
    }

}
