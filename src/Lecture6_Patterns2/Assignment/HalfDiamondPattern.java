package Lecture6_Patterns2.Assignment;

import java.util.Scanner;

public class HalfDiamondPattern {
    /*
    Write a program to print N number of rows for Half Diamond pattern using stars and numbers
Note : There are no spaces between the characters in a single line.


Input Format :
A single integer: N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
*
*1*
*121*
*12321*
*121*
*1*
*
Sample Input 2 :
 5
Sample Output 2 :
*
*1*
*121*
*12321*
*1234321*
*123454321*
*1234321*
*12321*
*121*
*1*
*
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N =s.nextInt();
        s.close();
        System.out.println('*');
        int i=1,j=1;
        // First Half
        while (i<=N){
        int currcol = 1;
            System.out.print('*');
        while (currcol<=i){
            System.out.print(currcol);
            currcol++;
        }
        currcol= currcol-2;
        while (currcol>=1){
            System.out.print(currcol);
            currcol--;
        }
            System.out.print('*');
            System.out.println();
            i++;
        }
        //Secong Half
        while (j<=N-1){
            int curCol = 1;
            System.out.print('*');
            while (curCol<=(N-1-j+1)){
                System.out.print(curCol);
                curCol++;
            }
            curCol = curCol-2;
            while (curCol>=1){
                System.out.print(curCol);
                curCol--;
            }
            System.out.print('*');
            System.out.println();
            j++;
        }
        System.out.println('*');
    }
}
