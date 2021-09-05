package _03_array_in_java.exercise;

import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input col of Array");
        int col = sc.nextInt();
        System.out.println("Please input row of Array");
        int row = sc.nextInt();
        int [][]arr = new int[col][row];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print("arr["+i+"]["+j+"]: ");
                arr[i][j]=sc.nextInt();
                System.out.println();
            }
        }
        int max = arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Max in Array:"+max);
    }
}
