package model;

public class TrinhDo {
    String id;
    String trinhDo;

    public TrinhDo() {
    }

    public TrinhDo(String id, String trinhDo) {
        this.id = id;
        this.trinhDo = trinhDo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }
}
