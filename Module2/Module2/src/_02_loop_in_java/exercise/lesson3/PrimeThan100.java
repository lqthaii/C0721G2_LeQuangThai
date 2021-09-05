package _02_loop_in_java.exercise.lesson3;

public class PrimeThan100 {
    public static void main(String[] args) {
        boolean flag = true;
        for (int n = 2; n < 100; n++) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.print(n + " ");
            } else {
                flag = true;
            }
        }
    }
}
