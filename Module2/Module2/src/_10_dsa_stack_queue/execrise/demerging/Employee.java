package _10_dsa_stack_queue.execrise.demerging;

public class Employee {
    String id;
    String name;
    String birthday;
    String sex;
    public Employee(String id, String name, String birthday, String sex) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Employee() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
