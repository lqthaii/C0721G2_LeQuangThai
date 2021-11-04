package model;

public class Level {
    String id;
    String level;

    public Level() {
    }

    public Level(String id, String trinhDo) {
        this.id = id;
        this.level = trinhDo;
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
}
