package Group3.set2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
You have been given a Binary Search Tree of integers. You are supposed to convert it to a greater sum tree such that the value of every node in the given BST is replaced with the sum of the values of all the nodes which are greater than the value of the current node in the tree.
A Binary Search Tree is a tree, whose internal nodes each store a value greater than all the values in the node's left subtree and less than those in its right subtree.
Note :
You need to modify the given tree only. You are not allowed to create a new tree.
For example:
For the given binary search tree
Example
11 will be replaced by {15 + 29 + 35 + 40}, i.e. 119.
2 will be replaced by {7 + 11 + 15 + 29 + 35 + 40}, i.e. 137.
29 will be replaced by {35 + 40}, i.e. 75.
1 will be replaced by {2 + 7 + 11 + 15 + 29 + 35 + 40}, i.e. 139.
7 will be replaced by {11 + 15 + 29 + 35 + 40}, i.e. 130.
15 will be replaced by {15 + 29 + 35 + 40}, i.e. 104.
40 will be replaced by 0 {as there is no node with a value greater than 40}.
35 will be replaced by {40}, i.e. 40.
Input Format:
The first line contains an integer 'T', which denotes the number of test cases. Then the test cases follow.

The first line of each test case contains elements in the level order form. The line consists of values of nodes separated by a single space. In case a node is null, we take -1 on its place.

For example, the input for the tree depicted in the below image would be :
Example
1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1
Explanation :
Level 1 :
The root node of the tree is 1

Level 2 :
Left child of 1 = 2
Right child of 1 = 3

Level 3 :
Left child of 2 = 4
Right child of 2 = null (-1)
Left child of 3 = 5
Right child of 3 = 6

Level 4 :
Left child of 4 = null (-1)
Right child of 4 = 7
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

Level 5 :
Left child of 7 = null (-1)
Right child of 7 = null (-1)

The first not-null node(of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.
The input ends when all nodes at the last level are null(-1).
Note :
The above format was just to provide clarity on how the input is formed for a given tree.
The sequence will be put together in a single line separated by a single space. Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
Output Format:
For each test case, print a single line that contains the level order traversal of the greater sum tree where all nodes are printed in a single-space separated manner.

The output of each test case will be printed in a separate line.
Note :
You do not need to print anything; it has already been taken care of. Just implement the given function.
Constraints:
1 <= 'T' <= 100
0 <= 'N' <= 1000
0 <= 'DATA' <= 10 ^ 4 and 'DATA' != -1

Where ‘N’ is the total number of nodes in the binary search tree, and 'DATA' is the value of the binary search tree node.

Time Limit: 1sec
Sample Input 1:
2
5 2 7 1 3 6 8 -1 -1 -1 -1 -1 -1 -1 -1
4 2 5 -1 3 -1 6 -1 -1 -1 -1
Sample Output 1:
21 29 8 31 26 15 0
11 18 6 15 0
Explanation of Sample Input 1:
For the first test case, after converting the given binary tree into the greater sum tree, the level order traversal of the tree will be {21, 29, 8, 31, 26, 15, 0}, where 5 will be replaced by {6+7+8} i.e. 21, 3 will be replaced by {5+6+7+8} i.e. 26, 7 will be replaced by {8} i.e. 8, 1 will be replaced by {2+3+5+6+7+8} i.e. 33, 2 will be replaced by {3+5+6+7+8} i.e. 26, 6 will be replaced by {7+8} i.e. 15 and 8 will be replaced by 0 (because no node has a value greater than 8 in the given tree).

For the second test case, after converting the given binary tree into the greater sum tree, the level order traversal of the tree will be {11, 18, 6, 15, 0}, where, 4 will be replaced by {5+6} i.e. 11, 2 will be replaced by {3+4+5+6} i.e. 18, 5 will be replaced by {6} i.e. 6, 3 will be replaced by {4+5+6} i.e. 15 and 6 will be replaced by 0 (because no node has a value greater than 6 in the given tree).
Sample Input 2:
2
11 2 29 1 7 15 40 -1 -1 -1 -1 -1 -1 35 -1 -1 -1
10 5 15 2 7 12 20 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
119 137 75 139 130 104 0 40
47 64 20 69 57 35 0
Explanation of Sample Input 2:
For the first test case, after converting the given binary tree into the greater sum tree, the level order traversal of the tree will be {119, 137, 75. 130, 104, 0, 40}.

For the second test case, after converting the given binary tree into the greater sum tree, the level order traversal of the tree will be {47, 64, 20, 69, 57, 35, 0}.
 */
class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.val = data;
        left = null;
        right = null;
    }
}
public class BstToGreaterSum {

    static Scanner s = new Scanner(System.in);

    private static void printLevelOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }

        }
    }

    private static TreeNode<Integer> takeInput() {
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> currentNode = q.poll();
            int leftChild = s.nextInt();

            if (leftChild != -1) {
                TreeNode<Integer> leftNode = new TreeNode<Integer>(leftChild);
                currentNode.left = leftNode;
                q.add(leftNode);
            }

            int rightChild = s.nextInt();

            if (rightChild != -1) {
                TreeNode<Integer> rightNode = new TreeNode<Integer>(rightChild);
                currentNode.right = rightNode;
                q.add(rightNode);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        while (t > 0) {

            TreeNode<Integer> root = takeInput();
            TreeNode<Integer> bstToGreaterSum = convertBstToGreaterSum(root);
            printLevelOrder(root);
            System.out.println();
            t--;
        }
        // s.close();

    }
    static int greaterSum = 0;
    public static class Sum {
        int sum = 0;
    }
    public static TreeNode<Integer> convertBstToGreaterSum(TreeNode<Integer> root) {
        Sum  ss = new Sum();
          Helper(root,ss);
        return root;
    }
    static void Helper(TreeNode<Integer> root, Sum s) {
        if (root == null)
            return;
        Helper(root.right,s);
        s.sum = s.sum + root.val;
        root.val = s.sum - root.val;
        Helper(root.left,s);
    }
}
