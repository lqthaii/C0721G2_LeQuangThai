package services;

import models.Booking;
import models.Contract;
import models.Customer;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ContractServiceImpl implements ContactService {
    static Scanner sc = new Scanner(System.in);
    static Queue<Booking> bookingQueue = new LinkedList<>();
    static List<Contract> contractList = new ArrayList<>();
    static final String PATH_CONTRACT = "src\\data\\contract.csv";
    static final String PATH_BOOKING = "src\\data\\booking.csv";

    static {
        readFileBooking();
        readFileContract();
    }

    private static void readFileContract() {
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
    }

    private static void readFileBooking() {
        try {
            File file = new File(BookingServiceImpl.PATCH_BOOKING);
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
    }

    private void writeFileContract(String path) {
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

    private void updateFileBooking(String path) {
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

    @Override
    public void add() {
        readFileBooking();
        Contract contract = inputContract();
        contractList.add(contract);
        writeFileContract(PATH_CONTRACT);
    }

    @Override
    public void edit() {
        display();
        boolean flag = false;
        System.out.println("Please input ID Contract you want to edit:");
        String id = sc.nextLine();
        if (checkIsExist(id) != -1) {
            Contract contract = inputContract();
            contractList.set(checkIsExist(id), contract);
        } else {
            System.err.println("Contract ID does not exist");
        }
        writeFileContract(PATH_CONTRACT);
    }

    @Override
    public void display() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    public int checkIsExist(String id) {
        int i = 0;
        for (Contract contract : contractList) {
            i++;
            if (id.equals(contract.getIdContract())) {
                return i;
            }
        }
        return -1;
    }

    public Contract inputContract() {
        String idContract;
        do {
            System.out.println("Please input ID Contract");
            idContract = sc.nextLine();
            if (checkIsExist(idContract) != -1) {
                System.err.println("ID Contract already not exist!!");
            }
        } while (checkIsExist(idContract) != -1);
        Booking booking = bookingQueue.poll();
        updateFileBooking(PATH_BOOKING);
        Customer customer = booking.getCustomer();
        System.out.println("Please input Advance Deposit  Amount");
        double adcAmout = Double.parseDouble(sc.nextLine());
        System.out.println("Please input Total Amount");
        double totalAmount = Double.parseDouble(sc.nextLine());
        return new Contract(idContract, booking, customer, adcAmout, totalAmount);
    }

}
