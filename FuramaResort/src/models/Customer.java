package models;

public class Customer extends Person {
    private String id;
    private String guestType;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String birthday, String sex, String identity, String numberphone, String email, String guestType, String address) {
        super(name, birthday, sex, identity, numberphone, email);
        this.id = id;
        this.guestType = guestType;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String writeFile(){
        return this.id+","+this.name+","+this.birthday+","+this.sex+","+this.identity+","+this.numberphone+","+this.email+","+this.guestType+","+this.address;
    }
    @Override
    public String toString() {
        return "Customer: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", guestType='" + guestType + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", identity='" + identity + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'';
    }
}
