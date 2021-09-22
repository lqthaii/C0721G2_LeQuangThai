package _14_exception_debug.execrise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập số a:");
            float a = sc.nextFloat();
            System.out.println("Nhập số b:");
            float b = sc.nextFloat();
            System.out.println("Nhập số c:");
            float c = sc.nextFloat();
            if(a<=0||b<=0||c<=0) throw new IllegalTriangleException("Lỗi đầu vào");
            if(a+b<c||a+c<b||b+c<a) throw new IllegalTriangleException("Số truyền vào không đúng");
        } catch (IllegalTriangleException e) {
            System.err.println(e);
        }
    }
}
