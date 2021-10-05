package models;

public class Contract {
    private String idContract;
    private Booking booking;
    private Customer customer;
    private double advanceAmount;
    private double amount;

    public Contract(String idContract, Booking booking, Customer customer, double advanceAmount, double amount) {
        this.idContract = idContract;
        this.booking = booking;
        this.customer = customer;
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Override
    public String toString() {
        return "Contract{" +
                "idContract='" + idContract + '\'' +
                ", booking=" + booking.getIdBooking() +
                ", customer=" + customer.getName() +
                ", advanceAmount=" + advanceAmount +
                ", amount=" + amount +
                '}';
    }
    public String writeFile(){
        return this.getIdContract()+","+this.getBooking().getIdBooking()+","+this.getCustomer().getId()+","+this.getAdvanceAmount()+","+this.getAmount();
    }
}
