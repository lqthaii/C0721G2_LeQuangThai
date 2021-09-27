package _17_string_regex.exercise.number_phone_validate;

public class NumberPhoneTest {
    private static NumberPhone numberPhone;
    public static final String[] validPhone = new String[]{"(84)-(0978489648)"};
    public static final String[] invalidPhone = new String[]{"(a8)-(22222222)"};

    public static void main(String args[]) {
        numberPhone = new NumberPhone();
        for (String phone : validPhone) {
            boolean isvalid = numberPhone.validate(phone);
            System.out.println("Number Phone is " + phone + " is valid: " + isvalid);
        }
        for (String phone : invalidPhone) {
            boolean isvalid = numberPhone.validate(phone);
            System.out.println("Number Phone is " + phone + " is valid: " + isvalid);
        }
    }
}

