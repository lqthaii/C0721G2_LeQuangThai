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
    public void setInformation(String id, String name, int age, String address, String classes, double salary){
        this.classes = classes;
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public void display() {
        System.out.printf("ID: %-5s|Họ và tên: %-20s|Tuổi:%2d|Dạy lớp:%5s|Địa chỉ: %-40s|Lương cơ bản: %-2f\n",this.id,this.name,this.age,this.classes,this.address,this.salary);
    }
}
