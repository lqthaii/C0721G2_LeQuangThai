package _10_dsa_stack_queue.execrise.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        System.out.println("Vui lòng nhập vào một chuỗi");
        String str = sc.nextLine();
        for(int i=str.length();i>0;i--){
            queue.add(str.toUpperCase().substring(i-1,i));
        }
        System.out.println(queue);
        //So sánh
        boolean flag = true;
        String temp;
        for(int i=0;i<str.length();i++){
            temp = str.toUpperCase().charAt(i)+"";
            if(!queue.poll().equals(temp)){
                flag=false;
            }
        }
        if(flag){
            System.out.println("Day la chuoi Palindrome");
        }else {
            System.out.println("Day khong phai la chuoi Palindrome");
        }
    }
}
