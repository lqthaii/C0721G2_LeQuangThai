package services;

import models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl extends Customer implements CustomerService {
    static protected List<Customer> customerList = new LinkedList<>();
    static {
        Customer customer = new Customer("Lê Quang Thái","26/10/2000","Nam","123456","123456789","quangthai645@gmail.com","1","Vip","Đăk Lăk");
        customerList.add(customer);
    }
    Scanner sc = new Scanner(System.in);

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
        Customer customer = new Customer(name,birthday,sex,id,phone,email,id,type,address);
        return customer;
    }
    @Override
    public void add() {
        Customer customer = inputCustomer();
        customerList.add(customer);
        System.out.println("Success!!....");
    }

    @Override
    public void delete() {
        display();
        System.out.println("Please input number you need delete:");
        int chooseDel;
        do {
            chooseDel = Integer.parseInt(sc.nextLine());
        } while (chooseDel < 0 || chooseDel > customerList.size());
        System.out.println("Are you sure that not remove?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choose;
        do {
            choose = Integer.parseInt(sc.nextLine());
        } while (choose <= 0 || choose > 2);
        if (choose == 1) {
            customerList.remove(chooseDel);
            System.out.println("Delete Success");
        } else {
            System.out.println("Canceled Success");
        }

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
}
