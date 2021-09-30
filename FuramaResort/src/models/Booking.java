package models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Booking implements Comparable<Booking> {
    private String idBooking;
    private Date dateStart;
    private Date dateEnd;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(String idBooking, Date dateStart, Date dateEnd, Customer customer, Facility facility) {
        this.idBooking = idBooking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.facility = facility;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDateStart = formatter.format(dateStart);
        String strDateEnd = formatter.format(dateEnd);
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dateStart=" + strDateStart +
                ", dateEnd=" + strDateEnd +
                ", Customer Name=" + customer.getName() +
                ", facility Name =" + facility.getName() +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
            return this.idBooking.compareTo(o.idBooking);
        }
}
