package Lecture6_Patterns2.Assignment;

import java.util.Scanner;

public class OddSquare {
    /*
    Write a program to print the pattern for the given N number of rows.
For N = 4
1357
3571
5713
7135
Input Format :
A single integer: N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
135
351
513
Sample Input 2 :
 5
Sample Output 2 :
13579
35791
57913
79135
91357

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int j=i;
            while (j<=N){
                int sum = 2*j-1;
                System.out.print(sum);
                j++;
            }
            int k=1;
            while (k<i){
                int sum = 2*k-1;
                System.out.print(sum);
                k++;
            }
            System.out.println();
            i++;

        }
    }
}
