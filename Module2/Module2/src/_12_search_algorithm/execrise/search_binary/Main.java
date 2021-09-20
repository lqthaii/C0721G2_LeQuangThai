package _12_search_algorithm.execrise.search_binary;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,7,8,9,10,11,15};
        int value =8;
        System.out.println(binarySearch(arr,value));
    }
    public static int binarySearch(int[] arr, int value){
        int left =0;
        int right = arr.length;
        while(left<right){
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
