package _01_loop_in_java.exercise.lesson1;

import java.util.Scanner;

public class PrintFigure {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    System.out.println("Please input length of rectangle");
                    int length = sc.nextInt();
                    System.out.println("Please input width of rectangle");
                    int width = sc.nextInt();
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < length; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw the square triangle");
                    System.out.println("Please input height of triangle");
                    int height = sc.nextInt();
                    //==============================================
                    System.out.println("(top-left)");
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    //==============================================
                    System.out.println("(top-right)");
                    for (int i = 0; i < height; i++) {
                        for (int j = height; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k <= i; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    //==============================================
                    System.out.println("(top-left)");
                    for (int i = height; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    //==============================================
                    System.out.println("(top-left)");
                    for (int i = height; i > 0; i--) {
                        for (int k = height - i; k > 0; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    //==============================================
                    break;
                case 3:
                    System.out.println("Draw the isosceles triangle");
                    System.out.println("Please input height of triangle");
                    height = sc.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= height - i; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
