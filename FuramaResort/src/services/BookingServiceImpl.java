package services;

import models.Booking;
import models.Customer;
import models.Facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingServiceImpl extends Booking implements BookingService{
    Scanner sc = new Scanner(System.in);
    static protected TreeSet<Booking> listBooking = new TreeSet<>();

    @Override
    public void add() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        customerService.display();
        System.out.println("Please entry ID Customer Booking:");
        String idCustomer = sc.nextLine();
        Customer customer = customerService.returnCustomer(idCustomer);
        if(customer!=null){
            System.out.println("Success!!....");
        }else {
            System.out.println("ERROR");
        }
        facilityService.display();
        System.out.println("Please entry number of Facility:");
        int choose = Integer.parseInt(sc.nextLine());
        Facility facility = facilityService.returnFacility(choose);
        if(facility!=null){
            System.out.println("Success!!....");
        }else {
            System.out.println("ERROR");
        }
        FacilityServiceImpl.increaseUsed(facility);
        System.out.println("Please entry ID Booking");
        String idbooking = sc.nextLine();
        System.out.println("Please entry begin date booking (dd/mm/yyyy)");
        String begindate = sc.nextLine();
        System.out.println("Please entry end date booking(dd/mm/yyyy)");
        String enddate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datestart = null ,dateend = null;
        try {
            datestart = formatter.parse(begindate);
            dateend = formatter.parse(enddate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Booking booking = new Booking(idbooking,datestart,dateend,customer,facility);
        listBooking.add(booking);
    }

    @Override
    public void delete() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        Iterator<Booking> iterator = listBooking.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
