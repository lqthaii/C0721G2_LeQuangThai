package services;

import models.Booking;
import models.Customer;
import models.Voucher;
import utils.ReadWriteBooking;
import utils.ReadWriteCustomer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PromotionServiceImpl {
    static Scanner sc = new Scanner(System.in);
    static TreeSet<Booking> allBookingList = ReadWriteBooking.readBooking(ReadWriteBooking.PATH_TOTAL_BOOKING);
    static Stack<Booking> bookingVouchers = new Stack<>();
    static Stack<Voucher> vouchers = new Stack<>();
    static Map<Customer,Voucher> customers = new LinkedHashMap<>();

    public void inputVoucher() {
        int vc10,vc20,vc50;
        do {
            System.out.println("You have "+bookingVouchers.size()+" Booking Now");
            System.out.println("Please input number Voucher 10%:");
            vc10 = sc.nextInt();
            System.out.println("Please input number Voucher 20%:");
            vc20 = sc.nextInt();
            System.out.println("Please input number Voucher 50%:");
            vc50 = sc.nextInt();
            if(!((vc10+vc20+vc50)==bookingVouchers.size())) System.err.println("Voucher not equal number booking");
        } while (!((vc10+vc20+vc50)==bookingVouchers.size()));
        int i = 0;
        for (i = 0; i < vc50; i++) {
            vouchers.add(new Voucher(Voucher.VOUCHER50));
        }
        for (i = 0; i < vc20; i++) {
            vouchers.add(new Voucher(Voucher.VOUCHER20));
        }
        for (i = 0; i < vc10; i++) {
            vouchers.add(new Voucher(Voucher.VOUCHER10));
        }
    }
    public void getCustomerVoucher(){
        while(!bookingVouchers.isEmpty()){
            Customer customer = bookingVouchers.pop().getCustomer();
            customers.put(customer,vouchers.pop());
        }
    }
    public void checkconditionVoucher(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        SimpleDateFormat format = new SimpleDateFormat("MM");
        int monthNow = localDate.getMonthValue();
        for(Booking booking : allBookingList){
           int monthBooking = Integer.parseInt(format.format(booking.getDateStart()));
           if(monthBooking==monthNow){
               bookingVouchers.push(booking);
           }
        }
    }
    public void displayCustomerGetVoucher(){
        checkconditionVoucher();
        inputVoucher();
        getCustomerVoucher();
        Set<Customer> set = customers.keySet();
        for (Customer customer : set) {
            System.out.println("Customer:"+customer.getName()+" Get Voucher: "+customers.get(customer));
        }
    }
}
