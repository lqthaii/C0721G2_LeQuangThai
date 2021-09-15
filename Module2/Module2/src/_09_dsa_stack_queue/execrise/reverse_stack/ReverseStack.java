package _09_dsa_stack_queue.execrise.reverse_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=stack.pop();
        }
        System.out.println(Arrays.toString(arr));
        //------------String----------------------
        Stack<String> mstack = new Stack<>();
        String mWord = "java string split method";
        String[] arrString = mWord.split("\\s");
        for(String a :arrString){
            mstack.push(a);
        }
        mWord ="";
        for(int i=0;i<arrString.length;i++){
            mWord += mstack.pop() +" ";
        }
        System.out.println(mWord);
    }
}
