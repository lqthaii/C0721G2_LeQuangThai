package models;

public class Voucher {
    String type;
    public static final String VOUCHER10 ="voucher10";
    public static final String VOUCHER20 ="voucher20";
    public static final String VOUCHER50 ="voucher50";
    public Voucher(String type) {
        this.type = type;
    }
    public Voucher() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
