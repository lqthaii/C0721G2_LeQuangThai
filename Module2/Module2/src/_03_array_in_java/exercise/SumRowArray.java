package _03_array_in_java.exercise;

import java.util.Scanner;

public class SumRowArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input col of Array");
        int col = sc.nextInt();
        System.out.println("Please input row of Array");
        int row = sc.nextInt();
        int[][] arr = new int[col][row];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("arr[" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
                System.out.println();
            }
        }
        System.out.println("Array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int colsum;
        do {
            System.out.println("Please enter the column you want to sum");
            colsum = sc.nextInt();
        }while(colsum<0||colsum>arr[0].length);
        int sum=0;
        for(int i=0;i<row;i++){
            sum+=arr[colsum][i];
        }
        System.out.println("Sum of arr["+colsum+"]="+sum);
    }
}
