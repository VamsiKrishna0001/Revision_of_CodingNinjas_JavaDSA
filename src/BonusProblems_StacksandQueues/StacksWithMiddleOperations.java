package BonusProblems_StacksandQueues;

import java.util.Scanner;

public class StacksWithMiddleOperations {
    /*
    1. You have to design a Stack class in which the user can access and delete the middle element in O(1) running time complexity.
2. The data members of the Stack class must be public.
Implement the following public functions:
1. Constructor:
 This function will initialize the data members.
2. push:
This function should take one argument of type int and has return type void. This function should insert an
element in the stack. Time complexity should be O(1).
3. pop:
This function takes no input arguments and has return type int. This should removes the last element which is
entered and return that element as an answer. Return 0 if stack is empty.
Time complexity should be O(1).
4. middle:
This function takes no input arguments and has return type int. This should return the middle element of stack.
Return 0, if the stack is empty. Time Complexity: O(1).
5. removeMiddle:
This function takes no input arguments and has a return type int. This should remove and return the data of
middle element of stack. Return 0, if the stack is empty.Time Complexity: O(1)
6. print:
This function takes no input arguments and has void return type. This should print all the elements of the stack. T
ime Complexity: O(n)
Note: If there are even number of elements in the stack, we should consider the first middle element as the middle one.
For example, in case of {1,2,3,4}; 2 is considered as the middle element.
Input Format:
The first and only line of input contains series of integers, terminated by -1. The integers represent choice.
For choice equal to 1, push function is called. When choice is 1, it is followed by another integer that denotes element to be inserted in the stack.
For choice equal to 2, pop function is called.
For choice equal to 3, middle function is called.
For choice equal to 4, removeMiddle function is called.
For choice equal to 5, print function is called.
Constraints:
Time Limit: 1 second
Output format:
The output lines are formatted according to the problem description.
Sample Input 1:
1 1 1 2 1 3 1 4 1 5 3 -1
Sample Output 1:
3


     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack st = new Stack();
        int choice = s.nextInt();
        int input;
        while (choice != -1) {
            if(choice == 1) {
                input = s.nextInt();
                st.push(input);
            }
            else if(choice == 2) {
                int ans = st.pop();
                if(ans != 0) {
                    System.out.println(ans);
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(choice == 3) {
                int ans = st.getmiddle();
                if(ans != 0) {
                    System.out.println(ans);
                }
                else {
                    System.out.println(-1);
                }
            }
            else if(choice == 4) {
                int ans = st.removeMiddle();
                if(ans != 0) {
                    System.out.println(ans);
                }
                else {
                    System.out.println(ans);
                }
            }
            else if(choice == 5) {
                st.print();
                System.out.println();
            }
            choice = s.nextInt();
        }
        s.close();
    }
}
class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class Stack{
    private Node head;
    private Node mid;
    private int size ;
    Stack(){
        head = null;
        mid=null;
        size=0;
    }
    public void push(int ele){
        Node newH = new Node(ele);
       if (head==null){
           head=newH;
           mid=newH;
           size++;
           return;
       }else {
           size++;
           newH.prev = head;
           head.next=newH;
           head=head.next;
           if (size%2 == 1)
               mid=mid.next;
       }
    }

    public int pop(){
    if (head==null) return 0;
    Node temp = head;
    head= head.prev;
    int ans = temp.data;
    size--;
    if (size%2 ==1) mid = mid.prev;
    return ans;
    }

    public int getmiddle(){
    if (mid==null) return 0;
    return mid.data;
    }

    public int removeMiddle(){
    if (mid == null) return 0;
    int ans = mid.data;
    Node pre = mid.prev;
    Node nex = mid.next;
    size--;
    if (size%2 == 1) mid = mid.next;
    else mid = mid.prev;
    if (mid.prev!=null) pre.next=nex;
    if (mid.next!=null) nex.prev=pre;
    return ans;
    }

    public void print(){
    if (head == null) return;
    Node temp = head;
    while (temp!=null){
        System.out.print(temp.data+" ");
        temp=temp.prev;
    }
    }
}


