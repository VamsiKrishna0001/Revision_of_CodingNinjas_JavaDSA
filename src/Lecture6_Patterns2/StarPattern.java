package Lecture6_Patterns2;

import java.util.Scanner;

public class StarPattern {
    /*
    Print the following pattern
Pattern for N = 4

The dots represent spaces.

Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
   *
  ***
 *****
Sample Input 2 :
4
Sample Output 2 :
    *
   ***
  *****
 *******
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int space=1;
            while (space<=(N-i)){
                System.out.print(' ');
                space++;
            }
            int j=1;
            while (j<=i){
                System.out.print('*');
                j++;
            }
            int k=1;
            while (k<i){
                System.out.print('*');
                k++;
            }
            System.out.println();
            i++;
        }

    }
}
