package Lecture10_Arrays2;

import java.util.Scanner;

public class SelectionSort {
    /*
    Provided with a random integer array/list(ARR) of size N, you have been required to sort this array using 'Selection Sort'.
 Note:
Change in the input array/list itself. You don't need to return or print the elements.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output format :
For each test case, print the elements of the array/list in sorted order separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1 sec
Sample Input 1:
1
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28
Sample Input 2:
2
5
9 3 6 2 0
4
4 3 2 1
Sample Output 2:
0 2 3 6 9
1 2 3 4
     */
    public static void main(String[] args) {
        int[] inputs = Takeinput();
        selectionSort(inputs);
        printArray(inputs);

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
    static void selectionSort(int[] arr){
        for (int i=0;i<arr.length;i++){
           int min = arr[i];
           int index = i;
           for (int j=i;j< arr.length;j++){
               if (min > arr[j]){
                   min = arr[j];
                   index = j;
               }
           }
           int temp = arr[i];
           arr[i]=arr[index];
           arr[index] = temp;
        }
    }
}
