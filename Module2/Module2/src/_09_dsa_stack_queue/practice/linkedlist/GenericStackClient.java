package _09_dsa_stack_queue.practice.linkedlist;

public class GenericStackClient {
    public static void main(String[] args) {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Thái");
        stack.push("Vy");
        stack.push("Việt");
        System.out.println("1.1 Size of stack after push operations: " + stack.size()); // Kiểm tra độ dài của stack
        System.out.printf("1.2. Pop elements from stack : "); //Lấy phần tử ra từ trên xuống
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());//Kiểm tra độ dài stack sau khi lấy
    }
}
