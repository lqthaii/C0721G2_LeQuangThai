package _17_string_regex.exercise.classes_validate;

import _17_string_regex.practice.email_example.EmailExample;

public class ClassesValidateExample {
    private static ClassesValidate classesValidate;
    public static final String[] validClass = new String[] {"C0721G","C0318G"};
    public static final String[] invalidClass = new String[] {"M0318G", "P0323A"};

    public static void main(String args[]) {
        classesValidate = new ClassesValidate();
        for (String classes : validClass) {
            boolean isvalid = classesValidate.validate(classes);
            System.out.println("Class is " + classes +" is valid: "+ isvalid);
        }
        for (String classes : invalidClass) {
            boolean isvalid = classesValidate.validate(classes);
            System.out.println("Class is " + classes +" is valid: "+ isvalid);
        }
    }
}
