package Lecture6_Patterns2;

import java.util.Scanner;

public class Diamondofstars {
    /*
    Print the following pattern for the given number of rows.
Note: N is always odd.


Pattern for N = 5



The dots represent spaces.



Input format :
N (Total no. of rows and can only be odd)
Output format :
Pattern in N lines
Constraints :
1 <= N <= 49
Sample Input 1:
5
Sample Output 1:
  *
 ***
*****
 ***
  *
Sample Input 2:
3
Sample Output 2:
  *
 ***
  *
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int i=1,j=1;
        int n1=(N+1)/2;
        int n2 = n1-1;

        while (i<=n1){
            int space=1;
            while (space<=n1-i){
                System.out.print(' ');
                space++;
            }
            int star=1;
            while (star<=(2*i)-1){
                System.out.print('*');
                star++;
            }
            i++;
            System.out.println();
        }
        while (j<=n2){
            int space=1;
            while (space<=j){
                System.out.print(' ');
                space++;
            }
            int star=1;
            while (star<=(2*(n2-j)+1)){
                System.out.print('*');
                star++;
            }
            j++;
            System.out.println();
        }
    }
}
