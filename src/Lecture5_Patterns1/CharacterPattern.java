package Lecture5_Patterns1;

import java.util.Scanner;

public class CharacterPattern {
    /*
    Print the following pattern for the given N number of rows.
Pattern for N = 4
A
BC
CDE
DEFG
Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints
0 <= N <= 13
Sample Input 1:
5
Sample Output 1:
A
BC
CDE
DEFG
EFGHI
Sample Input 2:
6
Sample Output 2:
A
BC
CDE
DEFG
EFGHI
FGHIJK
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.close();
        int i=64,j=1;
        while (j<=N){
            int k=0;
            i = i+j;
            while (k<j){
                System.out.print((char) i);
                k++;
                i++;
            }
            System.out.println();
            j++;
            i=64;
        }
    }
}
