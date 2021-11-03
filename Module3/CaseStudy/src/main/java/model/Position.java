package model;

public class Position {
    String id;
    String namePosition;

    public Position() {
    }

    public Position(String id, String namePosition) {
        this.id = id;
        this.namePosition = namePosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
