package _04_oop_in_java.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Giải phương tình bậc 2:");
        System.out.println("Nhập a:");
        int a = sc.nextInt();
        System.out.println("Nhập b:");
        int b = sc.nextInt();
        System.out.println("Nhập c:");
        int c = sc.nextInt();
        QuadraticEquation equal = new QuadraticEquation();
        equal.setA(a);
        equal.setB(b);
        equal.setC(c);
        double delta = equal.getDiscriminant();
        if(delta>0){
            System.out.println("The equation has two roots"+equal.getRoot1()+" and "+equal.getRoot2());
        }else if(delta==0) {
            System.out.println("The equation has one root " + equal.getRoot1());
        }else {
            System.out.println("The equation has not real roots ");
        }
    }
}
