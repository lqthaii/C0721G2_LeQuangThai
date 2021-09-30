package services;

import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl extends Employee implements EmployeeService {
    Scanner sc = new Scanner(System.in);
    static protected ArrayList<Employee> employees = new ArrayList<>();
    static final String PATCH_EMPLOYEE= "src\\data\\employee.csv";

    public void readFile(){
        try {
            File file = new File(PATCH_EMPLOYEE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr =line.split(",");
                for(int i=0;i<arr.length;i++){
                    System.out.println(arr[i]);
                }
                employees.add(new Employee(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],Double.parseDouble(arr[10])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }
    static {
        Employee employee = new Employee("1", "Nguyễn Văn A", "26/10/2000", "Nam", "123456789", "0867471079", "nguyenvanA@gmail.com", "Manager", "Chief", 4000);
        Employee employee1 = new Employee("2", "Dương Thị B", "11/03/1990", "Nữ", "14566789", "0123456789", "duongthiB@gmail.com", "1", "Service", 1000);
        Employee employee2 = new Employee("3", "Hồ Văn C", "19/12/1999", "Nam", "14564789", "0867471079", "hovanC@gmail.com", "0", "Employee", 500);
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
    }
    public void writeFile(String filePath){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(Employee employee : employees){
                bufferedWriter.write(employee.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        } else {
            System.out.println("ID already exists");
        }
    }

    @Override
    public void delete() {
        System.out.println("Please input ID:");
        String inputID = sc.nextLine();
        boolean result = false;
        for (Employee employee : employees) {
            if (inputID.equals(employee.getId())) {
                employees.remove(employee);
                result = true;
                break;
            }
        }
        if (!result) {
            System.out.println("Can't find ID to delete");
        } else {
            System.out.println("Successfully deleted");
        }
    }

    @Override
    public void edit() {
        System.out.println("Please input ID:");
        String inputID = sc.nextLine();
        boolean result = false;
        String id, name, birthday, sex, identity, numberphone, email, level, position;
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
        /*for (Employee employee : employees) {
            System.out.println(employee);
        }*/
        writeFile(PATCH_EMPLOYEE);
        readFile();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
