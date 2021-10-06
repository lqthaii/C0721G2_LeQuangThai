package services;

import models.*;
import utils.ReadWriteCustomer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl extends Customer implements CustomerService {
    List<Customer> customerList = ReadWriteCustomer.readFile();
    static Scanner sc = new Scanner(System.in);

    public Customer returnCustomer(String id) {
        Customer customerr = null;
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
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
        return new Customer(id, name, birthday, sex, id, phone, email, type, address);
    }

    @Override
    public void add() {
        Customer customer = inputCustomer();
        customerList.add(customer);
        ReadWriteCustomer.writeFile(ReadWriteCustomer.PATH_CUSTOMER, customerList);
        System.out.println("Success!!....");
    }

    @Override
    public void edit() {
        display();
        System.out.println("Please enter the customer order number to be repaired:");
        int chooseEdit;
        boolean result = false;
        do {
            chooseEdit = Integer.parseInt(sc.nextLine());
            Customer customer = inputCustomer();
            customerList.set(chooseEdit, customer);
            result = true;
        } while (chooseEdit < 0 || chooseEdit > customerList.size());
        if (result) {
            ReadWriteCustomer.writeFile(ReadWriteCustomer.PATH_CUSTOMER, customerList);
            System.out.println("Edit success");
        } else {
            System.out.println("Edit failure");
        }
    }

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public boolean isCustomer(String id) {
        for (Customer customer : customerList) {
            if (id.equals(customer.getId())) {
                return true;
            }
        }
        return false;
    }
}
