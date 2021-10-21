package Lecture6_Patterns2.Assignment;

import java.util.Scanner;

public class ParallelogramPattern {
    /*
    Write a program to print parallelogram pattern for the given N number of rows.
For N = 4


The dots represent spaces.
Input Format :
 A single integer : N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
***
 ***
  ***
Sample Input 2 :
5
Sample Output 2 :
*****
 *****
  *****
   *****
    *****
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int space=1;
            while (space<i){
                System.out.print(' ');
                space++;
            }
            int star=1;
            while (star<=N){
                System.out.print('*');
                star++;
            }
            i++;
            System.out.println();
        }
    }

}
