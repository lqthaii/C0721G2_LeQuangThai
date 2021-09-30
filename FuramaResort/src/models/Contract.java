package models;

public class Contract {
    private String idContract;
    private String idBooking;
    private String idCustomer;
    private double advanceAmount;
    private double amount;

    public Contract(String idContract, String idBooking, String idCustomer, double advanceAmount, double amount) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
        this.advanceAmount = advanceAmount;
        this.amount = amount;
    }

    public Contract() {
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
