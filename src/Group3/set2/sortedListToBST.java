package Group3.set2;

import java.util.ArrayList;
import java.util.Scanner;

/*
You have been given a singly linked list in which nodes are present in increasing order. Your task is to construct a Balanced Binary Search Tree with the same data elements as the given Linked List.
A Balanced BST is defined as a BST in which the height of two subtrees of every node differs no more than 1.
Input Format :
The first line of input contains an integer ‘T’ denoting the number of test cases to run. Then the test case follows.

The only line of each test case contains the elements of the singly linked list separated by a single space and terminated by -1. Hence, -1 would never be a list element.
Output Format :
For each test case, print the nodes of the tree in the level order form separated by single spaces (Print -1 for NULL nodes). Refer to the below example for further clarification.

Print the output for every test case in a separate line.
For Example
Consider the Binary Search Tree-
alt text
The above BST will be printed as-
12 10 14 -1 -1 -1 16 -1 -1

Explanation :
Level 1 :
The root node of the tree is 12

Level 2 :
Left child of 12 = 10
Right child of 12 = 14

Level 3 :
Left child of 10 = null(-1)
Right child of 10 = null (-1)
Left child of 14 = null(-1)
Right child of 16 = 16

Level 4 :
Left child of 16 = null (-1)
Right child of 16 = null (-1)

The first not-null node (of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.

The output for each test case ends when all nodes at the last level are null (-1).
Note :
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints :
1 <= T <= 100
0 <= N <= 1000
1 <= Data <= 10^9
Data != -1

Time Limit: 1sec
Sample Input 1 :
2
1 2 3 4 5 -1
5 7 8 -1
Sample Output 1:
3 2 5 1 -1 4 -1 -1 -1 -1 -1
7 5 8 -1 -1 -1 -1
Explanation for Sample Input 1:
Test Case 1: The balanced BST corresponding to the linked list is-
alt text
Level order traversal of above BST is 3 2 5 1 -1 4 -1 -1 -1 -1 -1

Test Case 2: The balanced BST corresponding to the linked list is-
alt text
Level order traversal of above BST is 7 5 8 -1 -1 -1 -1
Sample Input 2 :
2
10 12 14 16 -1
-1
Sample Output 2 :
12 10 14 -1 -1 -1 16 -1 -1
-1
 */
public class sortedListToBST {

    static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

   static class TreeNode<T> {
        T data;
        TreeNode<Integer> left;
        TreeNode right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode<Integer> sortedListToBST(Node<Integer> head) {
       return divideList(head);
    }


    public static Node<Integer> getMid(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        Node<Integer> prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    public static TreeNode<Integer> divideList(Node<Integer> head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode<Integer>(head.data);
        }

        Node<Integer> mid = getMid(head);

        Node<Integer>next = mid.next;
        mid.next = null;

        TreeNode<Integer> root = new TreeNode(next.data);
        root.left = divideList(head);
        root.right = divideList(next.next);

        return root;
    }

    public static ArrayList<Integer> in = new ArrayList<Integer>();
    public static ArrayList<Integer> check = new ArrayList<Integer>();

    static Scanner s = new Scanner(System.in);

    public static Node<Integer> takeLLInput() {

        check.clear();
        int data = s.nextInt();

        Node<Integer> head = null, tail = null;

        while (data != -1) {
            check.add(data);
            Node<Integer> newNode = new Node<Integer>(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            data = s.nextInt();
        }

        return head;
    }


    public static void print(TreeNode<Integer> poi)
    {
        if(poi==null)
            return;
        if(poi.left!=null)
            print(poi.left);
        in.add(poi.data);
        if(poi.right!=null)
            print(poi.right);

    }

    public static boolean isValid(TreeNode<Integer> root,Height height)
    {
        if(root==null)
        {
            height.height=0;
            return true;
        }

        Height lheight = new Height(), rheight = new Height();

        boolean l = isValid(root.left, lheight);
        boolean r = isValid(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        height.height = (lh > rh ? lh : rh) + 1;

        if (Math.abs(lh - rh) >= 2)
            return false;
        else
            return l && r;
    }

    public static void main(String[] args) {

        int t = s.nextInt();

        while (t-- > 0) {

            Node<Integer> head = takeLLInput();

            TreeNode<Integer> root = sortedListToBST(head);
            TreeNode<Integer> poi=root;
            in.clear();
            print(poi);



            if(in.equals(check)==false)
            {
                System.out.println("INCORRECT");
                continue;
            }

            Height h = new Height();
            if(isValid(root,h)==false)
            {
                System.out.println("INCORRECT");
                continue;
            }
            System.out.println("CORRECT");

        }

    }
}
class Height {
    int height = 0;
}
