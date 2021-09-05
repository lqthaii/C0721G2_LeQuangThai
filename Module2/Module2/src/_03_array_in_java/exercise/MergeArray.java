package _03_array_in_java.exercise;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = { 7, 8, 9, 10};
        int[] arr = new int[arr1.length + arr2.length];
        int i;
        for (i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        int j = 0;
        for (i = arr1.length; i < arr.length; i++) {
            arr[i] = arr2[j];
            j++;
        }
        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
