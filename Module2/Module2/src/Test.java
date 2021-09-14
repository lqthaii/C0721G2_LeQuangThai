import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int[] a = {8, 6, 7, 5, 3, 0, 9};
        // a[]  = Collections.reverse(Arrays.asList(a));
       /* int[] b = IntStream.rangeClosed(1, a.length).map(i -> a[a.length-i]).toArray();
        for(int i=0;i<a.length;i++){
            a[i] = b[i];
        }*/
        int i =2;
        System.out.println(a[i]);
        for( i=0;i<a.length;i=i+1){
            System.out.println(a[i]);
        }
    }
}
