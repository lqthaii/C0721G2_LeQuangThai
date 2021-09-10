package advance.oop_person;

public class Teacher extends Person {
    private String classes;
    private double salary;
    private String id;

    public Teacher() {
    }

    public Teacher(String id, String name, int age, String address, String classes, double salary) {
        super(name, age, address);
        this.classes = classes;
        this.salary = salary;
        this.id = id;
    }

    public String getId() {
        return id+"";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String display() {
        return "ID: " + this.id + "Họ và tên: " + this.name + ",Tuổi:" + this.age + ",Dạy lớp: " + this.classes + ",Địa chỉ: " + this.address + ",Lương cơ bản: " + this.salary;
    }
}
