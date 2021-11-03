package model;

public class Customer {
    private String id;
    private String idTypeCustomer;
    private String name;
    private String birthday;
    private String identity;
    private String email;
    private String address;
    private String numberPhone;

    public Customer() {
    }

    public Customer(String id, String idTypeCustomer, String name, String birthday, String identity, String email, String address, String numberPhone) {
        this.id = id;
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.birthday = birthday;
        this.identity = identity;
        this.email = email;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(String idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
