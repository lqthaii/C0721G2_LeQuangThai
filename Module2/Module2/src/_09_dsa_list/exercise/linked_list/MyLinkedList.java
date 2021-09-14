package _09_dsa_list.exercise.linked_list;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    public class Node{
        private Node next;
        private E data;
        public Node(E data){
            this.data = data;
        }
        public E getData(){
            return data;
        }
    }
    private Node head;
    private int numNodes;
    public MyLinkedList(){}
    public int size() {
        return numNodes;
    }
    public void add(int index, E element) {
        Node newNode = head;
        Node holder;

        for (int i = 0; i < index - 1 && newNode.next != null; i++) {
            newNode = newNode.next;
        }
        holder = newNode.next;
        newNode.next = new Node(element);
        newNode.next.next = holder;
        numNodes++;

    }
    public void addFirst(E e) {
        Node newNode = new Node(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        numNodes++; // Increase list size
    }
    public void addLast(E e) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }
    public E remove(int index){
            Node previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
    }
    public boolean remove(E o) {
        if (head.getData().equals(o)) {
            remove(o);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.getData().equals(o)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
    public E clone(){
        MyLinkedList<Object> temp = new MyLinkedList<>();
        Node tempNode = head;
        while (tempNode != null) {
            temp.addLast(tempNode.getData());
            tempNode = tempNode.next;
        }
        return (E)temp;
    }
    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public E getFirst() {
        Node temp = head;
        if (temp == null)
            throw new NoSuchElementException();
        return (E) temp.data;
    }
    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public void clear(){
        Node temp = head;
        while (temp.next != null) {
            temp.data = null;
            temp = temp.next;
        }
        numNodes = 0;
    }
}
