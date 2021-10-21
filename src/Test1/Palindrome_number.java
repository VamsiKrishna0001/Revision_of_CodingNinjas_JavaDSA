package Test1;

import java.util.Scanner;

public class Palindrome_number {
    /*
     Write a program to determine if given number is palindrome or not. Print true if it is palindrome, false otherwise.
Palindrome are the numbers for which reverse is exactly same as the original one. For eg. 121
Sample Input 1 :
121
Sample Output 1 :
true
Sample Input 2 :
1032
Sample Output 2 :
false
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        int num = n;
        int rev=0,rem;
        while (n!=0){
            rem = n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        System.out.println((rev == num) ? true : false);
    }
}
