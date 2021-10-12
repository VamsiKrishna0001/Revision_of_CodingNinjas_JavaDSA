package Lecture5_Patterns1;

import java.util.Scanner;

public class AlphaPattern {
    /*
    Print the following pattern for the given N number of rows.
Pattern for N = 3
 A
 BB
 CCC
Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints
0 <= N <= 26
Sample Input 1:
7
Sample Output 1:
A
BB
CCC
DDDD
EEEEE
FFFFFF
GGGGGGG
Sample Input 2:
6
Sample Output 2:
A
BB
CCC
DDDD
EEEEE
FFFFFF
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.close();
        int i=65,j=0;
        while (j<N){
            int k=0;
            while (k<=j){
                System.out.print((char)(i+j));
                k++;
            }
            System.out.println();
            j++;
        }
    }
}
