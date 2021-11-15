package Lecture22_Stacks.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckRedundantBrackets {
    /*
    For a given expression in the form of a string, find if there exist any redundant brackets or not.
    It is given that the expression contains only rounded brackets or parenthesis and the input
    expression will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or
needless brackets.
Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
Note:
You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
Input Format :
The first and the only line of input contains a string expression, without any spaces in between.
Output Format :
The first and the only line of output will print either 'true' or 'false'(without the quotes) denoting
whether the input expression contains redundant brackets or not.
Note:
You are not required to print the expected result. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1 second
Sample Input 1:
a+(b)+c
Sample Output 1:
true
Explanation:
The expression can be reduced to a+b+c. Hence, the brackets are redundant.
Sample Input 2:
(a+b)
Sample Output 2:
false
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();
        System.out.println(checkRedundantBrackets(expression));
    }

    private static boolean checkRedundantBrackets(String expression) {
        Stack<Character> st = new Stack<>();
        for (int i=0;i<expression.length();i++){
            if (expression.charAt(i) == ')'){
                int cnt=0;
                while (st.peek()!='('){
                    st.pop();
                    cnt++;
                }
                st.pop();
                if (cnt == 0 || cnt == 1) return true;
            }else {
                st.push(expression.charAt(i));
            }
        }
        return false;
    }
}
