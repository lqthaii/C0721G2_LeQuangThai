package _04_oop_in_java.exercise.stop_watch;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int arr[] = new int[100000];
        Random rd = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i] = rd.nextInt(2000);
        }
        SelectionSort ob = new SelectionSort();
        ob.sort(arr);
        stopWatch.end();
        /*for(int i : arr){
            System.out.print(i+" ");
        }*/
        System.out.println("Time: "+stopWatch.getElapsedTime());

    }
}
