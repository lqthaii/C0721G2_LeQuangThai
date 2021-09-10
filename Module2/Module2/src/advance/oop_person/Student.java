package advance.oop_person;

public class Student extends Person {
    private String conduct;
    private String classification;
    private String classes;
    private String id;

    public Student() {
    }

    public Student(String id, String name, int age, String address, String conduct, String classification, String classes) {
        super(name, age, address);
        this.conduct = conduct;
        this.classification = classification;
        this.classes = classes;
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public String getId() {
        return id+"";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String display() {
        return "ID: " + this.id + ",Họ và tên: " + this.name + ",Địa chỉ: " + this.address + ",Lớp: " + this.classes + ",Xếp loại: " + this.classification + ",Hạnh kiểm: " + this.conduct;
    }
}
