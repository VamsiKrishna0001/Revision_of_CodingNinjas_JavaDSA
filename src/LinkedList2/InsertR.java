package LinkedList2;

public class InsertR {

    public static Node<Integer> insertRecursive(Node<Integer> head,int pos,int data){
        if (head == null && pos>0){
            return head;
        }
        if (pos == 0){
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            return newNode;
        }else {
            head.next = insertRecursive(head.next,pos-1,data);
            return head;
        }
    }
}
