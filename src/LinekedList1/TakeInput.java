package LinekedList1;

import java.util.Scanner;

public class TakeInput {
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
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = Input();
        LinkedListUse.PrintLinkedList(head);
    }
}
