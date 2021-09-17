package _10_dsa_stack_queue.execrise.demerging;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Demerging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Employee> nu = new ArrayDeque<>();
        Queue<Employee> nam = new ArrayDeque<>();
        Employee[] employees = new Employee[3];
        String id,name,birthday,sex;
        for(int i=0;i<employees.length;i++){
            System.out.println("Tên");
            name = sc.nextLine();
            System.out.println("ID");
            id = sc.nextLine();
            System.out.println("Ngay Sinh");
            birthday = sc.nextLine();
            System.out.println("Gioi Tinh (Nu/Nam)");
            sex = sc.nextLine();
            employees[i] = new Employee(id,name,birthday,sex);
            if(employees[i].sex.toUpperCase().equals("NU")){
                nu.add(employees[i]);
            }
            else{
                nam.add(employees[i]);
            }
        }
        while(!nu.isEmpty()){
            System.out.println(nu.poll());
        }
        while(!nam.isEmpty()){
            System.out.println(nam.poll());
        }
    }
}
