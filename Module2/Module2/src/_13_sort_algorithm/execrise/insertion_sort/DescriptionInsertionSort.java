package _13_sort_algorithm.execrise.insertion_sort;

public class DescriptionInsertionSort {
    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            System.out.println("\nVòng lặp thứ "+i);
            int key = arr[i];
            int j = i;
            while( j > 0 && arr[ j - 1 ] > key ) {
                System.out.println("Hoán đổi phần tử "+arr[j-1]+"và phần tử "+arr[j]);
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=key;
            System.out.println("\nMảng sau khi hoán đổi là:");
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 4, 5, 8, 3, 5, 1, 4, 5 };
        insertionSort(arr);
        System.out.println("Mảng sau khi sắp xếp là");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
