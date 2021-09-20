package _12_search_algorithm.execrise.find_maximum_subsequence;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi");
        String str = sc.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.addLast(str.charAt(j));
                }else {
                    break;
                }
            }
            if (max.size() < list.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        System.out.println(max);
    }
}
