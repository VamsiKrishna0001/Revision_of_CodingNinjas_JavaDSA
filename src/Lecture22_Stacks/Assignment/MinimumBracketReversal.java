package Lecture22_Stacks.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumBracketReversal {
    /*
    For a given expression in the form of a string, find the minimum number of brackets that can
    be reversed in order to make the expression balanced. The expression will only contain curly brackets.
If the expression can't be balanced, return -1.
Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced.
Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening
bracket and hence will not be able to make the expression balanced and the output will be -1.
Input Format :
The first and the only line of input contains a string expression, without any spaces in between.
Output Format :
The only line of output will print the number of reversals required to balance the whole expression.
Prints -1, otherwise.
Note:
You don't have to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.println(countBracketReversals(br.readLine().trim()));

    }

    private static int countBracketReversals(String input) {
        int len = input.length();
        if (len == 0)return 0;
        if (len%2 == 0) return -1;

        Stack<Character> st = new Stack<>();
        for (int i=0;i<input.length();i++){
            if (input.charAt(i) == '{') st.push(input.charAt(i));
            else {
                if (!st.isEmpty() && st.peek() == '{')
                    st.pop();
                else {
                    st.push(input.charAt(i));
                }
            }
        }
        int cnt=0;
        while (!st.isEmpty()){
            char c1 = st.pop();
            char c2 = st.pop();
            if (c1 == c2) cnt++;
            else cnt+=2;
        }
        return cnt;
    }
}
