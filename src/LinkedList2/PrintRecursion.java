package LinkedList2;


import java.util.Scanner;

class Node<T>{
    T data;
    Node<T> next;
    Node(T data){
        this.data= data;
    }
}
public class PrintRecursion {

    public static Node<Integer> Input(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null,tail=null;
        while (data!=-1){
            Node<Integer> Chead = new Node<>(data);
            if (head==null){
                head = Chead;
                tail = Chead;
            }else {
                tail.next = Chead;
                tail = Chead;
            }
            data =s.nextInt();
        }
        s.close();
        return head;
    }
    public static void printR(Node<Integer> head){
        if (head == null){
            return;
        }
        System.out.print(head.data+ " ");
        printR(head.next);
        // if u want reverse right the print statement after recursion

    }

    public static void main(String[] args) {
        Node<Integer> head = Input();
        printR(head);
    }

}
