package utils;

import models.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteCustomer {
    public static final String PATH_CUSTOMER = "src\\data\\customer.csv";

    public static void writeFile(String filePath, List<Customer> customerList) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFile() {
        List<Customer> customerList = new LinkedList<>();
        try {
            File file = new File(PATH_CUSTOMER);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                customerList.add(new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return customerList;
    }
}
