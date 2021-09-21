package _13_sort_algorithm.execrise.insertion_sort;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i;
            while( j > 0 && arr[ j - 1 ] > key ) {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=key;
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
