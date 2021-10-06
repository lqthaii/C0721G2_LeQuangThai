package utils;

import models.Booking;
import services.CustomerServiceImpl;
import services.FacilityServiceImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class ReadWriteBooking {
    public static final String PATH_BOOKING = "src\\data\\booking.csv";
    public static final String PATH_TOTAL_BOOKING = "src\\data\\totalBooking.csv";

    public static void writeFile(String patch, TreeSet<Booking> listBooking) {
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

    public static void writeBooking(String patch, Booking booking) {
        try {
            FileWriter writer = new FileWriter(patch, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(booking.writeFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Booking> readBooking() {
        TreeSet<Booking> listBooking = new TreeSet<>(new BookingComparator());
        try {
            File file = new File(PATH_BOOKING);
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
        return listBooking;
    }
}
