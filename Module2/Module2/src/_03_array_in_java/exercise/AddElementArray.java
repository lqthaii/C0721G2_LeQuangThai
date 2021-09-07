package _03_array_in_java.exercise;

import java.util.Scanner;

public class AddElementArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        // Nhâp số phần tử của màng
        array = new int[size]; // Khởi tạo mảng
        int[] arrnew = new int[array.length + 1];
        int i = 0;


        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        } // Nhập giá trị các phần tử của mảng



        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        } //In ra mảng



        System.out.println("Please input element you want add to array");
        int element = scanner.nextInt();
        System.out.println("Please input location you want add");
        int index = scanner.nextInt();


        for (int j = 0; j < array.length; j++) {
            arrnew[j] = array[j];
        }
        //Gán giá trị mảng cho 1 mảng mới dài hơn 1 đơn vị

        if (index <= -1 || index >= arrnew.length - 1) {
            System.out.println("Cannot add element to array");
        } else {
            for (i = arrnew.length - 1; i > index; i--) {
                arrnew[i] = arrnew[i - 1];
            }
            arrnew[index] = element;
        }
        //Thêm phần tử vào mảng
        array = arrnew;
        //Gán mảng mới vào lại mảng ban đầu
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        } //In ra mảng
    }
}
