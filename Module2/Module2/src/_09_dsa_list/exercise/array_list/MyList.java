package _09_dsa_list.exercise.array_list;

import java.util.AbstractCollection;
import java.util.Arrays;

public class MyList<E>  {
    private int size =0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    private void ensureCapa() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
        E e =(E) elements[index];

        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size(){
        return size;
    }
    public E clone(){
            MyList<Object> clone = new MyList<>(size);
            clone.elements= Arrays.copyOf(elements, size);
            clone.size = 0;
            return (E) clone;
    }
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i]))
                return true;
        return false;
    }
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }
    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }
    public E get(int i){
        if (i >= size)
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size );
        return (E) elements[i];
    }
        public void clear() {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
            size = 0;
        }
}
