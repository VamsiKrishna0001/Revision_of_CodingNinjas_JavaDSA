package Lecture5_Patterns1;

import java.util.Scanner;

public class SquarePattern {
    /*

    Print the following pattern for the given N number of rows.
Pattern for N = 4
4444
4444
4444
4444

Input format :

Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints
0 <= N <= 50

Sample Input 1:
7
Sample Output 1:
7777777
7777777
7777777
7777777
7777777
7777777
7777777
Sample Input 1:
6
Sample Output 1:
666666
666666
666666
666666
666666
666  cfvcvf666
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.close();
        int i=0;
        while (i<N){
           int j=0;
            while (j<N){
                System.out.print(N);
                j++;
            }
            System.out.println();
            i++;

        }
    }
}
