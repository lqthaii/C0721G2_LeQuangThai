package _03_array_in_java.exercise;

import java.util.Scanner;

public class AddElementArray {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] array = inputArray();//Nhập mảng
        outputArray(array);//Xuất mảng
        System.out.println("Please input element you want add to array");
        int element = scanner.nextInt();
        System.out.println("Please input location you want add");
        int index = scanner.nextInt();
        array = addElement(array,index,element);
        //Gán mảng mới vào lại mảng ban đầu
        outputArray(array);//Xuất mảng sau khi thêm
    }
    public static int[] inputArray(){
        int size;
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);
        //Nhập số phần tử của mảng
        int i = 0;
        int[] array = new int[size];
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        } // Nhập giá trị các phần tử của mảng
        return array;
    }
    public static void outputArray(int[] array){
        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        //In ra mảng
    }
    public static int[] addElement(int[] array, int index, int element){
        int[] arrnew = new int[array.length + 1];
        for (int j = 0; j < array.length; j++) {
            arrnew[j] = array[j];
        }
        if (index <= -1 || index >= arrnew.length ) {
            System.out.println("Cannot add element to array");
        } else {
            for (int i = arrnew.length - 1; i > index; i--) {
                arrnew[i] = arrnew[i - 1];
            }
            arrnew[index] = element;
        }
        return arrnew;
    }
}
