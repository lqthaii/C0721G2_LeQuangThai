package IntroductionJava.Exercise.Lesson2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập số cần đọc");
        int n;
        String read = "";
        do {
            n = sc.nextInt();
            if (n < 0 || n > 999) {
                System.out.println("Bạn đã nhập sai vui lòng nhập lại!");
            }
        } while (n < 0 || n > 999);
        if (n < 20) {
            switch (n) {
                case 1:
                    read = "one";
                    break;
                case 2:
                    read = "two";
                    break;
                case 3:
                    read = "three";
                    break;
                case 4:
                    read = "four";
                    break;
                case 5:
                    read = "five";
                    break;
                case 6:
                    read = "six";
                    break;
                case 7:
                    read = "seven";
                    break;
                case 8:
                    read = "eight";
                    break;
                case 9:
                    read = "night";
                    break;
                case 10:
                    read = "ten";
                    break;
                case 11:
                    read = "eleven";
                    break;
                case 12:
                    read = "twelve";
                    break;
            }
        } else if (n < 20) {
            n = n % 10;
            switch (n) {
                case 3:
                    read = "thirteen";
                    break;
                case 4:
                    read = "fourteen";
                    break;
                case 5:
                    read = "fifteen";
                    break;
                case 6:
                    read = "sixteen";
                    break;
                case 7:
                    read = "seventeen";
                    break;
                case 8:
                    read = "eighteen";
                    break;
                case 9:
                    read = "nighteen";
                    break;
            }
        } else if (n < 100) {
            int unit = n % 10;
            n /= 10;
            switch (n) {
                case 2:
                    read = "twenty";
                    break;
                case 3:
                    read = "thirty";
                    break;
                case 4:
                    read = "forty";
                    break;
                case 5:
                    read = "fifty";
                    break;
                case 6:
                    read = "sixty";
                    break;
                case 7:
                    read = "seventy";
                    break;
                case 8:
                    read = "eighty";
                    break;
                case 9:
                    read = "nighty";
                    break;
            }
            switch (unit) {
                case 1:
                    read += " one";
                    break;
                case 2:
                    read += " two";
                    break;
                case 3:
                    read += " three";
                    break;
                case 4:
                    read += " four";
                    break;
                case 5:
                    read += " five";
                    break;
                case 6:
                    read += " six";
                    break;
                case 7:
                    read += " seven";
                    break;
                case 8:
                    read += " eight";
                    break;
                case 9:
                    read += " night";
                    break;
            }
        } else {
            int unit = n % 10;
            n /= 10;
            int dozens = n % 10;
            n /= 10;
            switch (n) {
                case 1:
                    read = "one hundred";
                    break;
                case 2:
                    read = "two hundred";
                    break;
                case 3:
                    read = "three hundred";
                    break;
                case 4:
                    read = "four hundred";
                    break;
                case 5:
                    read = "five hundred";
                    break;
                case 6:
                    read = "six hundred";
                    break;
                case 7:
                    read = "seven hundred";
                    break;
                case 8:
                    read = "eight hundred";
                    break;
                case 9:
                    read = "night hundred";
                    break;
            }
            switch (dozens) {
                case 2:
                    read += " twenty";
                    break;
                case 3:
                    read += " thirty";
                    break;
                case 4:
                    read += " forty";
                    break;
                case 5:
                    read += " fifty";
                    break;
                case 6:
                    read += " sixty";
                    break;
                case 7:
                    read += " seventy";
                    break;
                case 8:
                    read += " eighty";
                    break;
                case 9:
                    read += " nighty";
                    break;
            }
            switch (unit) {
                case 1:
                    read += " one";
                    break;
                case 2:
                    read += " two";
                    break;
                case 3:
                    read += " three";
                    break;
                case 4:
                    read += " four";
                    break;
                case 5:
                    read += " five";
                    break;
                case 6:
                    read += " six";
                    break;
                case 7:
                    read += " seven";
                    break;
                case 8:
                    read += " eight";
                    break;
                case 9:
                    read += " night";
                    break;
            }
        }
        System.out.println("Số bạn được đọc là: " + read);
    }
}
