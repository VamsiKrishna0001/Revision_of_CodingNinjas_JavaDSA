package Group2.Set1.Test5;

public class GroupSum {
    /*
    Given an integer array A of size N and an integer k, check if it is possible to choose a group of some of the integers in the array such that the group sums to the given target k.
There is one with this additional constraint -
if there are numbers in the array that are adjacent and having identical values, they must either all be chosen, or none of them chosen.
Return true or false.
For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.

Input Format :
Line 1 : Integer N
Line 2 : Elements of array (separated by space)
Line 3 : Integer k
Output Format :
true or false
Constraints :
1 <= N <= 30
1 <= Ai <= 10^4
Sample Input 1 :
4
2 4 4 8
14
Sample Output 1 :
false
Sample Input 2 :
5
2 4 4 1 8
16
Sample Output 2 :
true
     */
    public static boolean subsetSumToKIdentical(int input[], int n,int k){
        for (int i = 0; i < (n - 1); i++) {
            for (int j = (i + 1); j < n; j++) {
                if (input[i] + input[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }
}
