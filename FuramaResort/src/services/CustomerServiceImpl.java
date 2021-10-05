package services;

import models.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl extends Customer implements CustomerService {
    static protected List<Customer> customerList = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static final String PATCH_CUSTOMER = "src\\data\\customer.csv";
    static {
        try {
            File file = new File(PATCH_CUSTOMER);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr =line.split(",");
               customerList.add(new Customer(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
    public void writeFile(String filePath){
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(Customer customer : customerList){
                bufferedWriter.write(customer.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer returnCustomer(String id){
        Customer customerr = null;
        for(Customer customer : customerList){
            if(customer.getId().equals(id)){
                customerr = customer;
            }
        }
        return customerr;
    }
    public Customer inputCustomer() {
        System.out.println("ID:");
        String id = sc.nextLine();
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Type:");
        String type = sc.nextLine();
        System.out.println("Address:");
        String address = sc.nextLine();
        System.out.println("Birthday:");
        String birthday = sc.nextLine();
        System.out.println("Sex:");
        String sex = sc.nextLine();
        System.out.println("Identity:");
        String indentity = sc.nextLine();
        System.out.println("Numberphone:");
        String phone = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        return new Customer(id,name,birthday,sex,id,phone,email,type,address);
    }
    @Override
    public void add() {
        Customer customer = inputCustomer();
        customerList.add(customer);
        writeFile(PATCH_CUSTOMER);
        System.out.println("Success!!....");
    }

    @Override
    public void edit() {
        display();
        System.out.println("Please enter the customer order number to be repaired:");
        int chooseEdit;
        boolean result =false;
        do {
            chooseEdit = Integer.parseInt(sc.nextLine());
            Customer customer = inputCustomer();
            customerList.set(chooseEdit,customer);
            result =true;
        } while (chooseEdit < 0 || chooseEdit > customerList.size());
        if(result){
            writeFile(PATCH_CUSTOMER);
            System.out.println("Edit success");
        }else{
            System.out.println("Edit failure");
        }
    }

    @Override
    public void display() {
        for(Customer customer : customerList){
            System.out.println(customer);
        }
    }
    public boolean isCustomer(String id){
        for(Customer customer : customerList){
            if(id.equals(customer.getId())){
                return true;
            }
        }
        return false;
    }
}
