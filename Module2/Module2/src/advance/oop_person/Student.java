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
    public void setInformation(String id, String name, int age, String address, String conduct, String classification, String classes){
        this.conduct = conduct;
        this.classification = classification;
        this.classes = classes;
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public void display() {
        System.out.format("ID: %-5|Họ và tên:%-20s|Tuổi: %-2d|Lớp: %-5s|Địa chỉ: %-40s|Xếp loại: %-5s|Hạnh kiểm: %-5s\n",this.id,this.name,this.age,this.classes,this.address,this.classification,this.conduct);
    }
}
