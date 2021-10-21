package Test1;

import java.util.Scanner;

public class CheckAp {
    /*
    Given input consists of n numbers. Check whether those n numbers form an arithmetic progression or not. Print true or false.
Input format :
Line 1 : n
Line 2 : n numbers
Sample Input 1 :
6
2 6 10 14 18 22
Sample Output 1 :
true
Sample Input 2 :
6
2 6 10 15 19 23
Sample Output 2 :
false
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N=s.nextInt();
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int diff= n2-n1;
        n1=n2;
        for (int i =3;i<=N;i++){
            n2=s.nextInt();
            int d = n2-n1;
            if (diff!=d){
                System.out.println("false");
                return;
            }
            n1=n2;
        }
        System.out.println("true");
    }
}
