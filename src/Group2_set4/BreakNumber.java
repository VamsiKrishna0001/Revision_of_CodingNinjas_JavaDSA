package Group2_set4;

import java.util.Scanner;

public class BreakNumber {
    /*
    Given an integer n, break it into smaller numbers such that their summation is equal to n. Print all such combinations in different lines.
Note : [1, 2, 1] and [1,1, 2] are same, so print the particular sequence with increasing order. Order of different combinations doesn't matter.
Input format :
Integer n
Output format :
Print all possible combinations in different lines
Constraints :
1 <= n <= 100
Input :
4
Output :
1 1 1 1
1 1 2
1 3
2 2
4
     */
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int number = s.nextInt();
        printCombination(number);
    }
    public static void printCombination(int num){
        //Write your code here
        printAllUniqueParts(num);

    }

    static void printArray(int p[], int n)
    {
        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    static void printAllUniqueParts(int n) {
        int[] p = new int[n];
        int k = 0;
        p[k] = n;


        while (true) {

            printArray(p, k + 1);

            int rem_val = 0;
            while (k >= 0 && p[k] == 1) {
                rem_val += p[k];
                k--;
            }
            if (k < 0) return;

            p[k]--;
            rem_val++;
            while (rem_val > p[k]) {
                p[k + 1] = p[k];
                rem_val = rem_val - p[k];
                k++;
            }

            p[k + 1] = rem_val;
            k++;
        }
    }
}
