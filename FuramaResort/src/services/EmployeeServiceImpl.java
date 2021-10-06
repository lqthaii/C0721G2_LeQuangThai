package services;

import models.Employee;
import utils.ReadFileEmployee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl extends Employee implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    static protected ArrayList<Employee> employees = ReadFileEmployee.readFile();

    public Employee inputData() {
        String id, name, birthday, sex, identity, numberphone, email, level, position;
        double salary;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.print("ID: ");
            id = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Birthday: ");
            birthday = sc.nextLine();
            System.out.print("Sex: ");
            sex = sc.nextLine();
            System.out.print("Identity: ");
            identity = sc.nextLine();
            System.out.print("Number Phone: ");
            numberphone = sc.nextLine();
            System.out.print("Email: ");
            email = sc.nextLine();
            System.out.print("Level: ");
            level = sc.nextLine();
            System.out.print("Position: ");
            position = sc.nextLine();
            System.out.print("Salary: ");
            salary = Double.parseDouble(sc.nextLine());
            System.out.println("-------------------------------------------------------");
            if (id == null) {
                System.out.println("You have not entered ID");
            } else if (name == null) {
                System.out.println("You have not entered Name");
            }
        } while (id == null || name == null);
        return new Employee(id, name, birthday, sex, identity, numberphone, email, level, position, salary);
    }

    @Override
    public void add() {
        Employee inputEmployee = inputData();
        boolean flag = true;
        for (Employee employee : employees) {
            if (inputEmployee.getId().equals(employee.getId())) {
                flag = false;
            }
        }
        if (flag) {
            employees.add(inputEmployee);
            ReadFileEmployee.writeFile(ReadFileEmployee.PATH_EMPLOYEE, employees);
        } else {
            System.out.println("ID already exists");
        }
    }

    @Override
    public void edit() {
        System.out.println("Please input ID:");
        String inputID = sc.nextLine();
        boolean result = false;
        String name, birthday, sex, identity, numberphone, email, level, position;
        double salary;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Birthday: ");
            birthday = sc.nextLine();
            System.out.print("Sex: ");
            sex = sc.nextLine();
            System.out.print("Identity: ");
            identity = sc.nextLine();
            System.out.print("Number Phone: ");
            numberphone = sc.nextLine();
            System.out.print("Email: ");
            email = sc.nextLine();
            System.out.print("Level: ");
            level = sc.nextLine();
            System.out.print("Position: ");
            position = sc.nextLine();
            System.out.print("Salary: ");
            salary = Double.parseDouble(sc.nextLine());
            System.out.println("-------------------------------------------------------");
            if (name == null) {
                System.out.println("You have not entered Name");
            }
        } while (name == null);
        for (Employee employee : employees) {
            if (inputID.equals(employee.getId())) {
                employee.setEmployee(inputID, name, birthday, sex, identity, numberphone, email, level, position, salary);
                result = true;
                ReadFileEmployee.writeFile(ReadFileEmployee.PATH_EMPLOYEE, employees);
                break;
            }
        }
        if (!result) {
            System.out.println("Can't find ID to edit");
        } else {
            System.out.println("Successfully edit");
        }
    }

    @Override
    public void display() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
