package models;

public abstract class Person {
    String name;
    String birthday;
    String sex;
    String identity ;
    String numberphone;
    String email;

    public Person() {
    }

    public Person(String name, String birthday, String sex, String identity , String numberphone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.identity  = identity;
        this.numberphone = numberphone;
        this.email = email;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
