package Lecture10_Arrays2;

import java.util.Scanner;

public class Mergesort {
    /*
    You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M respectively, merge them into a third array/list such that the third array is also sorted.
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements of the first array/list.

Third line contains an integer 'M' representing the size of the second array/list.

Fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output Format :
For each test case, print the sorted array/list(of size N + M) in a single row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
0 <= M <= 10^5
Time Limit: 1 sec
Sample Input 1 :
1
5
1 3 4 7 11
4
2 4 6 13
Sample Output 1 :
1 2 3 4 4 6 7 11 13
Sample Input 2 :
2
3
10 100 500
7
4 7 9 25 30 300 450
4
7 45 89 90
0
Sample Output 2 :
4 7 9 10 25 30 100 300 450 500
7 45 89 90

     */
    public static void main(String[] args) {
        int[] inputs ={1 ,3 ,4 ,7 ,11};
        int[] input1 = {2,4,6,13};
        printArray(MergeTwoSorted(inputs,input1));

    }
    static int[] Takeinput(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static int[] MergeTwoSorted(int[] arr1,int[] arr2){
        int arr3[] = new int[arr1.length+arr2.length];
        int j=0,k=0;
        for (int i=0;i<arr3.length;i++){
            if (j<arr1.length && k < arr2.length){
                if (arr1[j]<arr2[k]){
                    arr3[i]=arr1[j];
                    j++;
                }else {
                    arr3[i]=arr2[k];
                    k++;
                }
            }else if (j<arr1.length){
                arr3[i]=arr1[j];
                j++;
            }
            else if (k<arr2.length){
                arr3[i]=arr2[k];
                k++;
            }
        }
        return arr3;
    }

}
