package Group1;

import java.util.Scanner;

public class MAXIMUMSUBAARRAY {
    /*
    This problem was asked by Amazon.
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
Given the array [-5, -1, -8, -9], the maximum sum would be -1.
Follow up: Do this in O(N) time.
Input Format:
The first line of input contains size of array, which is denoted by N and second line of input contains N space separated integers.
Output Format:
The first and only line of output should print the maximum subarray sum, as described in the description.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxSubarraySum(arr, n));
//        int MAX = Integer.MIN_VALUE, Dmax = 0;
//
//        for (int i = 0; i < n; i++)
//        {
//            Dmax = Dmax + arr[i];
//            if (MAX < Dmax)
//                MAX = Dmax;
//            if (Dmax < 0)
//                Dmax = 0;
//        }
//        System.out.println( MAX);
    }
    public static int maxSubarraySum(int[] arr,int n) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i: arr) {
            maxEndingHere = maxEndingHere + i;

            maxEndingHere = Integer.max(maxEndingHere, 0);

            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
