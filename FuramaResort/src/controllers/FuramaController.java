package controllers;


import services.*;
import java.util.Scanner;


public class FuramaController {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FacilityServiceImpl.resetFacility();
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choose;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Manager Furama Resort DaNang City");
            System.out.println("Please choose function:");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            System.out.println("------------------------------------------");
            System.out.print("Choose: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    menuEmployee();
                    break;
                case 2:
                    menuCustomer();
                    break;
                case 3:
                    menuFacility();
                    break;
                case 4:
                    menuBooking();
                    break;
                case 5:
                    menuPromotion();
                    break;
                case 6:
                    System.out.println("Successful exit");
                    break;
                default:
                    System.out.println("ERROR - 404 \nPlease choose from 1 to 6:");
            }
        } while (choose != 6);
    }

    public static void menuEmployee() {
        int chooseFunction;
        do {
            System.out.println("******************************************");
            System.out.println("Please choose function manager Employee:");
            System.out.println("1.Display list employees");
            System.out.println("2.Add new employee");
            System.out.println("3.Edit employee");
            System.out.println("4.Return main menu");
            System.out.println("******************************************");
            EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
            System.out.print("Choose: ");
            chooseFunction = Integer.parseInt(sc.nextLine());
            if (chooseFunction == 1) {
                employeeService.display();
            } else if (chooseFunction == 2) {
                employeeService.add();
            } else if (chooseFunction == 3) {
                employeeService.edit();
            } else if (chooseFunction == 4) {
                System.out.println("Return Success !!");
            } else System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
        } while (chooseFunction != 4);
    }

    public static void menuCustomer() {
        int chooseFunction;
        do {
            System.out.println("******************************************");
            System.out.println("Please choose function manager Customer:");
            System.out.println("1.Display list customers");
            System.out.println("2.Add new customer");
            System.out.println("3.Edit customer");
            System.out.println("4.Return main menu");
            System.out.println("******************************************");
            CustomerServiceImpl customerService = new CustomerServiceImpl();
            System.out.print("Choose: ");
            chooseFunction = Integer.parseInt(sc.nextLine());
            if (chooseFunction == 1) {
                customerService.display();
            } else if (chooseFunction == 2) {
                customerService.add();
            } else if (chooseFunction == 3) {
                customerService.edit();
            } else if (chooseFunction == 4) {
                System.out.println("Return Success !!");
            } else System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
        } while (chooseFunction != 4);
    }

    public static void menuFacility() {
        int chooseFunction;
        do {
            System.out.println("******************************************");
            System.out.println("Please choose function manager Facility :");
            System.out.println("1.Display list facility");
            System.out.println("2.Add new facility");
            System.out.println("3.Display list facility maintenance");
            System.out.println("4.Return main menu");
            System.out.println("******************************************");
            FacilityServiceImpl facilityService = new FacilityServiceImpl();
            System.out.print("Choose: ");
            chooseFunction = Integer.parseInt(sc.nextLine());
            if (chooseFunction == 1) {
                facilityService.display();
            } else if (chooseFunction == 2) {
                facilityService.add();
            } else if (chooseFunction == 3) {
                facilityService.displayMaintenance();
            } else if (chooseFunction == 4) {
                System.out.println("Return Success !!");
            } else System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
        } while (chooseFunction != 4);
    }

    public static void menuBooking() {
        int chooseFunction;
        do {
            System.out.println("******************************************");
            System.out.println("Please choose function manager Booking:");
            System.out.println("1.Add new booking");
            System.out.println("2.Display list booking");
            System.out.println("3.Create new constracts");
            System.out.println("4.Display list contracts");
            System.out.println("5.Edit contracts");
            System.out.println("6.Return main menu");
            System.out.println("******************************************");
            System.out.print("Choose: ");
            chooseFunction = Integer.parseInt(sc.nextLine());
            BookingServiceImpl bookingService = new BookingServiceImpl();
            ContractServiceImpl contractService = new ContractServiceImpl();
            if (chooseFunction == 1) {
                bookingService.add();
            } else if (chooseFunction == 2) {
                bookingService.display();
            } else if (chooseFunction == 3) {
                contractService.add();
            } else if (chooseFunction == 4) {
                contractService.display();
            } else if (chooseFunction == 5) {
                contractService.edit();
            } else if (chooseFunction == 6) {
                System.out.println("Return Success !!");
            } else System.out.println("ERROR - 404 \nPlease choose from 1 to 4:");
        } while (chooseFunction != 4);
    }

    public static void menuPromotion() {
        int chooseFunction;
        do {
            System.out.println("******************************************");
            System.out.println("Please choose function manager Promotion:");
            System.out.println("1.Display list customers use service");
            System.out.println("2.Display list customers get voucher");
            System.out.println("3.Return main menu");
            System.out.println("******************************************");
            System.out.print("Choose: ");
            chooseFunction = Integer.parseInt(sc.nextLine());
            if (chooseFunction == 1) {

            } else if (chooseFunction == 2) {

            }
            if (chooseFunction == 3) {
                System.out.println("Return Success !!");
            } else {
                System.out.println("ERROR - 404 \nPlease choose from 1 to 3:");
            }
        } while (chooseFunction != 3);
    }
}
