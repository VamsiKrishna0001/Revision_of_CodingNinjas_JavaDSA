package Lecture6_Patterns2.Assignment;

import java.util.Scanner;

public class SumPattern {
    /*
    Write a program to print triangle of user defined integers sum.
Input Format :
A single integer, N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
1=1
1+2=3
1+2+3=6
Sample Input 2 :
 5
Sample Output 2 :
1=1
1+2=3
1+2+3=6
1+2+3+4=10
1+2+3+4+5=15

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N= s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int sum=0;
            int j=1;
            while (j<=i){
                System.out.print(j);
                sum+=j;
                if (i>1 && j<i){
                    System.out.print("+");
                }
                j++;
            }
            System.out.print("="+sum);
            System.out.println();
            i++;
        }
    }


}
