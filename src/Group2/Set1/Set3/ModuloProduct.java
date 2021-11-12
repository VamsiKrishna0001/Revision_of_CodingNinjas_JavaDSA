package Group2.Set1.Set3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModuloProduct {
    /*
    Ninja got an easy assignment from his professor but he is unable to solve this. So he needs your help to complete the assignment.
In the assignment, he is given two integers A and B and he needs to output the product of all numbers from 1 to A modulo B, where 1 and A are inclusive.
For example, if A=5 and B=7, the answer will be ( 1 * 2 * 3 * 4 * 5 ) % 7 = 1 so the final answer is 1.
Input format:
The first line of input will contain an integer T, that denote the number of test cases.
Every test case will consist of one single line and that line will contain two integers: A and B.
Constraints:
1<=T<=50
1<=A<=10^9
1<=B<=10^5
Time Limit: 1 second
Output format:
For every test case, print the output in a newline.
Sample Input 1
4
8 10
5 140
18 19
20 21
Sample Output 1:
0
120
18
0

     */
    public static void main(String[] args) throws IOException,NumberFormatException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //Scanner s = new Scanner(System.in);
//        int n=Integer.parseInt(br.readLine());
        int n =Integer.parseInt(br.readLine().trim());
        while (n>0) {
            int arr[] = new int[2];
            String[] strNums;
            strNums = br.readLine().split("\\s");
            for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(strNums[i]);
            }
            int a = arr[0];
            int b = arr[1];
            long prd = 1;
            if (a>=b){
                prd=0;
                System.out.println(prd);
                continue;
            }
            for (int i=1;i<=a;i++){
                prd=(prd* i)% b;
            }
            System.out.println(prd);
        }
        n--;
    }
}
