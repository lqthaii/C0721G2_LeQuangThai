package model;

public class Part{
    String id;
    String part_name;

    public Part() {
    }

    public Part(String id, String part_name) {
        this.id = id;
        this.part_name = part_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }
}
