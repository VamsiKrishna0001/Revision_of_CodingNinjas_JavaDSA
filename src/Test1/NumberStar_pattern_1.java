package Test1;

import java.util.Scanner;

public class NumberStar_pattern_1 {
    /*
    Print the following pattern for given number of rows.
Input format :
Integer N (Total number of rows)
Output Format :
Pattern in N lines
Sample Input :
   5
Sample Output :
 5432*
 543*1
 54*21
 5*321
 *4321

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        s.close();
        int i=1;
        while (i<=N){
            int k=N;
            while (k >=1){
                if (i == k){
                    System.out.print('*');
                }else {
                    System.out.print(k);
                }
                k--;
            }
            System.out.println();
            i++;
        }
    }
}
