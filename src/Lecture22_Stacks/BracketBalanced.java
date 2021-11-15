package Lecture22_Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketBalanced {
    /*
    For a given a string expression containing only round brackets or parentheses, check if
    they are balanced or not. Brackets are said to be balanced if the bracket which opens last,
    closes first.
Example:
Expression: (()())
Since all the opening brackets have their corresponding closing brackets, we say it is balanced
and hence the output will be, 'true'.
You need to return a boolean value indicating whether the expression is balanced or not.
Note:
The input expression will not contain spaces in between.
Input Format:
The first and the only line of input contains a string expression without any spaces in between.
 Output Format:
The only line of output prints 'true' or 'false'.
Note:
You don't have to print anything explicitly. It has been taken care of. Just implement the function.
Constraints:
1 <= N <= 10^7
 Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1 :
(()()())
Sample Output 1 :
true
Sample Input 2 :
()()(()
Sample Output 2 :
false
Explanation to Sample Input 2:
The initial two pairs of brackets are balanced. But when you see, the opening bracket at the fourth
index doesn't have its corresponding closing bracket which makes it imbalanced and in turn, making
the whole expression imbalanced. Hence the output prints 'false'.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException,NumberFormatException {
        String Expression = br.readLine().trim();
        System.out.println(isBalanced(Expression));
    }

    private static final List<Character> leftBraces = Arrays.asList('{','[','(');
    private static final List<Character> rightBraces = Arrays.asList('}',']',')');

    private static boolean isLeft(char exp){
        return leftBraces.contains(exp);
    }
    private static boolean isRight(char exp){
        return rightBraces.contains(exp);
    }

    private static boolean isMatched(char left,char right){
        return leftBraces.indexOf(left) == rightBraces.indexOf(right);
    }
    public static boolean isBalanced(String express){
        Stack<Character> stack = new Stack();
        for (char ch : express.toCharArray()){
            if (isLeft(ch)){
                stack.push(ch);
            }
            if (isRight(ch)){
               if (stack.isEmpty()) return false;
               char top = stack.pop();
               if (!isMatched(top,ch)) return false;
            }
        }
        return stack.isEmpty();
    }
}
