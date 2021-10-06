package utils;

import models.Booking;
import models.Contract;
import services.BookingServiceImpl;
import services.CustomerServiceImpl;
import services.FacilityServiceImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadWriteContract {
    public static final String PATH_CONTRACT = "src\\data\\contract.csv";
    public static final String PATH_BOOKING = "src\\data\\booking.csv";

    public static List<Contract> readFileContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            File file = new File(PATH_CONTRACT);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            BookingServiceImpl bookingService = new BookingServiceImpl();
            CustomerServiceImpl customerService = new CustomerServiceImpl();
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                contractList.add(new Contract(arr[0], bookingService.getBooking(arr[1]), customerService.returnCustomer(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return contractList;
    }

    public static Queue<Booking> readFileBooking() {
        Queue<Booking> bookingQueue = new LinkedList<>();
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
                bookingQueue.add(new Booking(arr[0], datestart, dateend, customerService.returnCustomer(arr[3]), facilityService.returnFacility(arr[4])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return bookingQueue;
    }

    public static void writeFileContract(String path, List<Contract> contractList) {
        try {
            FileWriter writer = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Contract contract : contractList) {
                bufferedWriter.write(contract.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFileBooking(String path, Queue<Booking> bookingQueue) {
        try {
            FileWriter writer = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Booking booking : bookingQueue) {
                bufferedWriter.write(booking.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
