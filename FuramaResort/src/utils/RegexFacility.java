package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFacility {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String ID_VILLA_REGEX = "^SVVL-\\d{4}$";
    private static final String ID_HOUSE_REGEX = "^SVHO-\\d{4}$";
    private static final String ID_ROOM_REGEX = "^SVRO-\\d{4}$";
    private static final String NAME_REGEX = "^[A-Z][a-z1-9]*$";
    private static final String AREA_REGEX = "^[\\d^012]\\d+.\\d+$";
    private static final String COST_REGEX = "^\\d+.\\d+$";
    private static final String QUANLITY_REGEX = "^+[01]\\d$";
    private static final String NUMBER_REGEX = "^+\\d{1,2}$";

    public boolean idVillaValidate(String id) {
        matcher = Pattern.compile(ID_VILLA_REGEX).matcher(id);
        return matcher.matches();
    }

    public boolean idHouseValidate(String id) {
        matcher = Pattern.compile(ID_HOUSE_REGEX).matcher(id);
        return matcher.matches();
    }

    public boolean idRoomValidate(String id) {
        matcher = Pattern.compile(ID_ROOM_REGEX).matcher(id);
        return matcher.matches();
    }

    public boolean nameValidate(String name) {
        matcher = Pattern.compile(NAME_REGEX).matcher(name);
        return matcher.matches();
    }

    public boolean areaValidate(String area) {
        matcher = Pattern.compile(AREA_REGEX).matcher(area);
        return matcher.matches();
    }

    public boolean quanlityValidate(String quanlity) {
        matcher = Pattern.compile(QUANLITY_REGEX).matcher(quanlity);
        return matcher.matches();
    }

    public boolean costValidate(String cost) {
        matcher = Pattern.compile(COST_REGEX).matcher(cost);
        return matcher.matches();
    }

    public boolean numberValidate(String number) {
        matcher = Pattern.compile(NUMBER_REGEX).matcher(number);
        return matcher.matches();
    }
}
