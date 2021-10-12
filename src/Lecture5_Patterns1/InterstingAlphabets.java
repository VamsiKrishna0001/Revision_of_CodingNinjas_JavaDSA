package Lecture5_Patterns1;

import java.util.Scanner;

public class InterstingAlphabets {
/*
Print the following pattern for the given number of rows.
Pattern for N = 5
E
DE
CDE
BCDE
ABCDE
Input format :
N (Total no. of rows)
Output format :
Pattern in N lines
Constraints
0 <= N <= 26

 */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.close();
        int i=0;
        while (i<N){
            char ith = (char)('Z'-26+N-i);
            int j=0;
            while (j<=i){
                System.out.print(ith);
                j++;
                ith++;
            }
            System.out.println();
            i++;
        }
    }
}
