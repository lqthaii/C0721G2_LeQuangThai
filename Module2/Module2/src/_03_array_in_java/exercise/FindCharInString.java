package _03_array_in_java.exercise;

import java.util.Scanner;

public class FindCharInString {
    public static void main(String[] args) {
        String str = "abcdefabhda";
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input character you want search");
        char ch = sc.next().charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(ch==str.charAt(i)){
                count++;
            }
        }
        System.out.println("Number char in String:"+count);
    }
}
