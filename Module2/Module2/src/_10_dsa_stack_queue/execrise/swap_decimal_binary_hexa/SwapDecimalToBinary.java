package _10_dsa_stack_queue.execrise.swap_decimal_binary_hexa;

import java.util.Scanner;
import java.util.Stack;

public class SwapDecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        System.out.println("Nhập vào một số nguyên:");
        int number = sc.nextInt();
        while(number>0){
            stack.push(number%2);
            number /=2;
        }
        String str ="";
        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        System.out.println("Số nhị phân của bạn là: "+ str);
    }
}
