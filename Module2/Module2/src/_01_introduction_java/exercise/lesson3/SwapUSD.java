package IntroductionJava.Exercise.Lesson3;


import java.util.Scanner;

public class SwapUSD {
    public static void main(String[] args) {
        final int RATE = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào số USD cần chuyển đổi:");
        int usd = Integer.parseInt(sc.nextLine());
        int vnd = usd * RATE;
        System.out.println("Số tiền thực nhận là:" + vnd);
    }
}
