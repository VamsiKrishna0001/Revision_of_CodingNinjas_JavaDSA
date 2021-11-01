package Group2Set6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfPowerOf3 {
    /*
    Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
Input Format:
First line of input contains an integer T, which represents the number of test cases.
Next T lines of input contains an integer n.
Constraints:
1 <= T <= 1000
1 <= n <= 10^4
Output Format:
 Print true if it is possibe to represent n as explained, otherwise print false.
Sample Input 1:
1
91
Sample Output 1:
true
Explanation:
3^0 + 3^2 + 3^4
Sample Input 2:
2
12
21
Sample Output 2:
true
false

     */

    static public boolean checkPowersOfThree(int n) {

        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }

            n /= 3;
        }
        return true;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());
        while (t != 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(checkPowersOfThree(n));
            t--;
        }

    }
}
