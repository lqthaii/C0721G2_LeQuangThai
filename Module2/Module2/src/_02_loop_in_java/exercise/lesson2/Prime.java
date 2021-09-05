package _02_loop_in_java.exercise.lesson2;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter the prime number you want to enter:");
            number = Integer.parseInt(sc.nextLine());
        }
        while (number < 0);
        int count = 0, n = 2;
        boolean flag = true;
        do {
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                System.out.print(n + " ");
                count++;
            } else {
                flag = true;
            }
            n++;
        } while (count < number);
    }
}
