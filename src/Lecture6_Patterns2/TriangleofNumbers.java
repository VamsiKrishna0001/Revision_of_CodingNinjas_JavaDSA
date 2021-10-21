package Lecture6_Patterns2;

import java.util.Scanner;

public class TriangleofNumbers {
    /*
    Print the following pattern for the given number of rows.
Pattern for N = 4



The dots represent spaces.



Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints :
0 <= N <= 50
Sample Input 1:
5
Sample Output 1:
           1
         232
       34543
     4567654
   567898765
Sample Input 2:
4
Sample Output 2:
           1
         232
       34543
     4567654
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int spaces = 1;
            while (spaces <=N-i){
                System.out.print(' ');
                spaces++;
            }
            int j=1;
            int midpart = 1+i-1;
            while (j<=i){
                System.out.print(midpart);
                j++;
                midpart++;
            }
            int endpart=2*i-2;
            while (endpart>=i){
                System.out.print(endpart);
                endpart--;
            }
            System.out.println();
            i++;
        }
    }
}
