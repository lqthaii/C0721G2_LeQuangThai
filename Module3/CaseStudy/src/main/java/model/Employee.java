package model;

public class Employee {
    private String id;
    private String name;
    private String position;
    private String level;
    private String part;
    private String birthday;
    private String identity;
    private String salary;
    private String numberPhone;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(String id, String name, String position, String level, String part, String birthday, String identity, String salary, String numberPhone, String email, String address) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.level = level;
        this.part = part;
        this.birthday = birthday;
        this.identity = identity;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
