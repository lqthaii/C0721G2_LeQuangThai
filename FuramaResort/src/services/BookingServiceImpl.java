package services;

import models.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingServiceImpl extends Booking implements BookingService {
    Scanner sc = new Scanner(System.in);
    static protected TreeSet<Booking> listBooking = new TreeSet<>();
    static final String PATCH_BOOKING = "src\\data\\booking.csv";
    static final String PATCH_TOTAL_BOOKING = "src\\data\\totalBooking.csv";
    static {
        try {
            File file = new File(PATCH_BOOKING);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                Date datestart = null, dateend = null;
                try {
                    datestart = formatter.parse(arr[1]);
                    dateend = formatter.parse(arr[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                FacilityServiceImpl facilityService = new FacilityServiceImpl();
                listBooking.add(new Booking(arr[0], datestart, dateend, customerService.returnCustomer(arr[3]), facilityService.returnFacility(arr[4])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    public void writeFile(String patch) {
        try {
            FileWriter writer = new FileWriter(patch, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Booking booking : listBooking) {
                bufferedWriter.write(booking.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {
        Customer customer=chooseCustomer();
        Facility facility = chooseFacility();
        String idbooking;
        FacilityServiceImpl.increaseUsed(facility);
        do {
            System.out.println("Please entry ID Booking");
            idbooking = sc.nextLine();
        }while(isIDBooking(idbooking));
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
        listBooking.add(new Booking(idbooking, datestart, dateend, customer, facility));
        writeFile(PATCH_BOOKING);
    }

    @Override
    public void edit() {
        System.out.println("Please input ");
    }

    @Override
    public void display() {
        for(Booking booking : listBooking){
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
    public Customer chooseCustomer(){
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
    public Facility chooseFacility(){
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
        }while(facility == null);
        return facility;
    }
}
