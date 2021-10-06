package services;

import models.*;
import utils.BookingComparator;
import utils.ReadWriteBooking;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingServiceImpl extends Booking implements BookingService {
    Scanner sc = new Scanner(System.in);
    TreeSet<Booking> listBooking = ReadWriteBooking.readBooking();

    @Override
    public void add() {
        Customer customer = chooseCustomer();
        FacilityServiceImpl.checkMaintenance();
        Facility facility = chooseFacility();
        String idbooking;
        do {
            System.out.println("Please entry ID Booking");
            idbooking = sc.nextLine();
        } while (isIDBooking(idbooking));
        System.out.println("Please entry begin date booking (dd/mm/yyyy)");
        String begindate = sc.nextLine();
        System.out.println("Please entry end date booking(dd/mm/yyyy)");
        String enddate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datestart = null, dateend = null;
        try {
            datestart = formatter.parse(begindate);
            dateend = formatter.parse(enddate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Booking booking = new Booking(idbooking, datestart, dateend, customer, facility);
        listBooking.add(booking);
        FacilityServiceImpl.increaseUsed(booking.getFacility().getId());
        ReadWriteBooking.writeFile(ReadWriteBooking.PATH_BOOKING, listBooking);
        ReadWriteBooking.writeBooking(ReadWriteBooking.PATH_TOTAL_BOOKING, booking);
    }

    @Override
    public void edit() {
    }

    @Override
    public void display() {
        for (Booking booking : listBooking) {
            System.out.println(booking);
        }
    }

    public boolean isIDBooking(String id) {
        for (Booking booking : listBooking) {
            if (id.equals(booking.getIdBooking())) {
                return true;
            }
        }
        return false;
    }

    public Booking getBooking(String id) {
        Booking booking = null;
        for (Booking booking1 : listBooking) {
            if (id.equals(booking1.getIdBooking())) {
                booking = booking1;
            }
        }
        return booking;
    }

    public Customer chooseCustomer() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer;
        do {
            customerService.display();
            System.out.println("Please entry ID Customer Booking:");
            String idCustomer = sc.nextLine();
            customer = customerService.returnCustomer(idCustomer);
            if (customer != null) {
                System.out.println("Success!!....");
            } else {
                System.out.println("ERROR");
            }
        } while (customer == null);
        return customer;
    }

    public Facility chooseFacility() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        Facility facility;
        do {
            facilityService.display();
            System.out.println("Please entry number of Facility:");
            int choose = Integer.parseInt(sc.nextLine());
            facility = facilityService.returnFacility(choose);
            if (facility != null) {
                System.out.println("Success!!....");
            } else {
                System.out.println("ERROR");
            }
        } while (facility == null);
        return facility;
    }
}
