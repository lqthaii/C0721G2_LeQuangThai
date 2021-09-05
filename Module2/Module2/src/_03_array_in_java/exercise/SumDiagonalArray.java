package _03_array_in_java.exercise;

import java.util.Scanner;

public class SumDiagonalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input col of Array");
        int col = sc.nextInt();
        int[][] arr = new int[col][col];
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

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
        }
        System.out.println("Sum Diagonal Array:"+sum);
    }
}
