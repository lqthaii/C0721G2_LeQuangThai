package _05_access_modifier_static.exercise.read_access_modifier;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {
    }
    protected void setName(String name){
        this.name = name;
    }
    protected void setClasses(String classes){
        this.classes=classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
