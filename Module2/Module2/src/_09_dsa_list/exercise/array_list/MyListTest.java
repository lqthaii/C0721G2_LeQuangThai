package _09_dsa_list.exercise.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList <Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.remove(0);
        System.out.println(myList.get(0));
        myList.clear();
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
    }
}
