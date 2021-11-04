package LinkedList2.Assignment;

public class SwapTwoNodes {
    /*
    You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.
Note :
Remember, the nodes themselves must be swapped and not the datas.

No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line of input contains two integer values 'i,' and 'j,' respectively. A single space will separate them.
 Remember/consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40
90 80 90 25 65 85 70
     */
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int I, int J) {
        if(head == null){
            return head;
        }
        LinkedListNode<Integer> prev1=null,curr1=head,curr2=head,prev2=null;

        for(int i=1;i<=I;i++){
            prev1=curr1;
            curr1=curr1.next;
        }
        for(int i=1;i<=J;i++){
            prev2=curr2;
            curr2=curr2.next;
        }
        if(prev1==null){
            head=curr2;
        }
        else{
            prev1.next=curr2;
        }

        LinkedListNode<Integer> temp=curr2.next;
        if(prev2!=curr1)
            curr2.next=curr1.next;
        else
            curr2.next=curr1;
        if(prev2==null){
            head=curr1;
        }
        else{
            prev2.next=curr1;
        }
        curr1.next=temp;
        return head;

    }
}
