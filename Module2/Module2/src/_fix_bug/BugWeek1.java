package _fix_bug;

import java.util.Arrays;

public class BugWeek1 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 12, 9, 6};
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Min = " + min);
    }
}