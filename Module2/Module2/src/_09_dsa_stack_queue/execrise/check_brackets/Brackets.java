package _09_dsa_stack_queue.execrise.check_brackets;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        Stack<String> bStack = new Stack<>();
        String str = "(– b + (b2 – 4*a*c)^0.5) / 2*a";

        if(checkBrackets(bStack,str)){
            System.out.println("Hợp lệ");
        }else{
            System.out.println("Không hợp lệ");
        }
    }
    public static boolean checkBrackets(Stack<String> bStack, String str){
        String left;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) + "").equals("(")) {
                bStack.push(str.charAt(i) + "");
                continue;
            }
            if ((str.charAt(i) + "").equals(")") && bStack.isEmpty()) {
                return false;
            }
            if ((str.charAt(i) + "").equals(")")) {
                bStack.pop();
                continue;
            }
        }
        if(!bStack.isEmpty()){
            return false;
        }
        return true;
    }
}
