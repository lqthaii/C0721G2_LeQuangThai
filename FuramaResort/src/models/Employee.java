package models;

public class Employee extends Person {
    private String id;
    private String level;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String level, String position, double salary, String id) {
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.id=id;
    }

    public Employee(String id,String name, String birthday, String sex, String identity, String numberphone, String email, String level, String position, double salary) {
        super(name, birthday, sex, identity , numberphone, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.id = id;
    }

    public void setEmployee(String id,String name, String birthday, String sex, String identity, String numberphone, String email, String level, String position, double salary){
        this.id=id;
        this.name=name;
        this.birthday=birthday;
        this.sex=sex;
        this.identity=identity;
        this.numberphone=numberphone;
        this.email = email;
        this.level = level;
        this.position = position;
        this.salary=salary;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: "+this.id+", Name: "+this.name+", Birthday: "+this.birthday+", Sex: "+this.sex+", Indentity: "+this.identity+", Numberphone: " +this.numberphone+
                ", Email: "+this.email+", Level: "+this.level+", Position: "+this.position+", Salary: "+this.salary;
    }
    public String writeFile(){
        return this.id+","+this.name+","+this.birthday+","+this.sex+","+this.identity+","+this.numberphone+","+this.email+","+this.level+","+this.position+","+this.salary;
    }
}
