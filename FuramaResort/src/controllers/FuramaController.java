package controllers;

import models.Customer;
import services.BookingServiceImpl;
import services.CustomerServiceImpl;
import services.EmployeeServiceImpl;
import services.FacilityServiceImpl;

import java.util.Currency;
import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
    public void displayMainMenu() {
        Scanner sc = new Scanner(System.in);
        int choose, chooseFunction;
        boolean flag = true;
        do {
            System.out.println("Manager Furama Resort DaNang City");
            System.out.println("Please choose function:");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Please choose function manager Employee:");
                    System.out.println("1.Display list employees");
                    System.out.println("2.Add new employee");
                    System.out.println("3.Edit employee");
                    System.out.println("4.Return main menu");
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    chooseFunction = Integer.parseInt(sc.nextLine());
                    if (chooseFunction == 1) {
                        employeeService.display();
                    } else if (chooseFunction == 2) {
                        employeeService.add();
                    } else if (chooseFunction == 3) {
                        employeeService.edit();
                    } else if (chooseFunction == 4) {
                        continue;
                    } else {
                        System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
                    }
                    break;
                case 2:
                    System.out.println("Please choose function manager Customer:");
                    System.out.println("1.Display list customers");
                    System.out.println("2.Add new customer");
                    System.out.println("3.Edit customer");
                    System.out.println("4.Return main menu");
                    CustomerServiceImpl customerService = new CustomerServiceImpl();
                    chooseFunction = Integer.parseInt(sc.nextLine());
                    if (chooseFunction == 1) {
                        customerService.display();
                    } else if (chooseFunction == 2) {
                        customerService.add();
                    } else if (chooseFunction == 3) {
                        customerService.edit();
                    } else if (chooseFunction == 4) {
                        continue;
                    } else {
                        System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
                    }
                    break;
                case 3:
                    System.out.println("Please choose function manager Facility :");
                    System.out.println("1.Display list facility");
                    System.out.println("2.Add new facility");
                    System.out.println("3.Display list facility maintenance");
                    System.out.println("4.Return main menu");
                    FacilityServiceImpl facilityService = new FacilityServiceImpl();
                    chooseFunction = Integer.parseInt(sc.nextLine());
                    if (chooseFunction == 1) {
                        facilityService.display();
                    } else if (chooseFunction == 2) {
                        facilityService.add();
                    } else if (chooseFunction == 3) {
                        facilityService.edit();
                    } else if (chooseFunction == 4) {
                        continue;
                    } else {
                        System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
                    }
                    break;
                case 4:
                    System.out.println("Please choose function manager Booking:");
                    System.out.println("1.Add new booking");
                    System.out.println("2.Display list booking");
                    System.out.println("3.Create new constracts");
                    System.out.println("4.Display list contracts");
                    System.out.println("5.Edit contracts");
                    System.out.println("6.Return main menu");
                    chooseFunction = Integer.parseInt(sc.nextLine());
                    BookingServiceImpl bookingService = new BookingServiceImpl();
                    if (chooseFunction == 1) {
                    bookingService.add();
                    } else if (chooseFunction == 2) {
                    bookingService.display();
                    } else if (chooseFunction == 3) {

                    } else if (chooseFunction == 4) {

                    } else if (chooseFunction == 5) {

                    } else if (chooseFunction == 6) {
                        continue;
                    } else {
                        System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
                    }
                    break;
                case 5:
                    System.out.println("Please choose function manager Promotion:");
                    System.out.println("1.Display list customers use service");
                    System.out.println("2.Display list customers get voucher");
                    chooseFunction = Integer.parseInt(sc.nextLine());
                    if (chooseFunction == 1) {

                    } else if (chooseFunction == 2) {

                    } else {
                        System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("ERROR - 404 \nPlease choose from 1 to 6:");
            }
        } while (flag);
    }
}
