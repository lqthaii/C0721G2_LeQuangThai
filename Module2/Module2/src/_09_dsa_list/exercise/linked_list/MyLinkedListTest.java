package _09_dsa_list.exercise.linked_list;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> listInteger = new MyLinkedList<>();
        listInteger.addFirst(1);
        listInteger.addLast(2);
        listInteger.addLast(3);
        System.out.println(listInteger);
        listInteger.add(4,5);
        System.out.println(listInteger);
        listInteger.addFirst(8);
        System.out.println(listInteger);
        listInteger.remove(1);
        System.out.println(listInteger);
        System.out.println(listInteger.contains(1));
        System.out.println(listInteger.contains(6));
//        listInteger.clear();
//        System.out.println(listInteger);

        System.out.println(listInteger.clone());

    }
}
