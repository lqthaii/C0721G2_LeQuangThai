package _04_oop_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Max2 {
    public static void main(String[] args) {
        int arr[] = {99, 99, 47, 85, 92, 52, 48, 36, 66, 81, 9};

        System.out.println("Mảng của bạn là:");
        // Xuất mảng
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
        int temp;
        //int max = arr[0];
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }*/
        Arrays.sort(arr);  //Sử dụng hàm sẵn có để sắp xếp
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        int max2=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max2 && arr[i]<arr[arr.length-1]){
                max2 = arr[i];
            }
        }
        System.out.println("Số lớn nhì trong mảng là: "+max2);
        int max = arr[0];
        /*int max2;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max2 = max;
                max = arr[i];
            }
        }
        System.out.println("Số lớn nhì trong mảng là: " + max2);*/
    }
}
