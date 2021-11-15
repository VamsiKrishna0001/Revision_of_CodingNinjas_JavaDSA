package Lecture22_Stacks;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
//        StackUsingArray stack = new StackUsingArray();
//        stack.push(10);
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());

        StackUsingLL<Integer> stack = new StackUsingLL<>();
        stack.push(12);
        stack.push(15);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
