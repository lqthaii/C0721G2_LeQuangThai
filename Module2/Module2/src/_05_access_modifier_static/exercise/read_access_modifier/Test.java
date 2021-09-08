package _05_access_modifier_static.exercise.read_access_modifier;

public class Test {
    public static void main(String[] args) {
        Student std = new Student();
        System.out.println(std.toString());
        std.setName("Thái");
        std.setClasses("C0721G2");
        System.out.println(std.toString());
    }
}
