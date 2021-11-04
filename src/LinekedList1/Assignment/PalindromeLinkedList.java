package LinekedList1.Assignment;

import java.util.Scanner;

public class PalindromeLinkedList {
    /*
    You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.
     */

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

    public static Node<Integer> reverse(Node<Integer> head){
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> frwd = null;

        while (curr!=null){
            frwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = frwd;
        }
        return prev;

//        if (head.next==null){
//            return head;
//        }
//        Node<Integer> store = head.next;
//        Node<Integer> rev = reverse(head.next);
//        store.next = head;
//        head.next = null;
//        return head;
    }


    // Time Complexity o(n)
    //Space Complexity O(1)


    public static boolean isPalindrome(Node<Integer> head){
        if (head == null && head.next == null){
            return true;
        }
        //Center
        // for breaking into two parts
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> Sechead = slow.next;
        slow.next = null;
        Sechead = reverse(Sechead);
        // compare two lists
        Node<Integer> First = Sechead;
        Node<Integer> Second = head;
        while (First!=null){
            if (!First.data.equals(Second.data)){
                return false;
            }
            First = First.next;
            Second = Second.next;
        }

        //Now rejoin the two lists to its original form
        First = head;
        Second = reverse(Second);
        while (First.next!=null){
            First = First.next;
        }
        First.next = Second;
        return true;



    }
public static void main(String[] args) {


        Node<Integer> head = Input();
        System.out.println(isPalindrome(head));
}

}
