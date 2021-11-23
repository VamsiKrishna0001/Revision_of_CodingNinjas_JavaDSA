package BonusProblems_StacksandQueues;

import java.util.Scanner;
import java.util.Stack;

public class MaximumrectangularArea {
    /*
    You are given a binary matrix. You have to print the maximum area possible for a sub-matrix with all 1's.
Input Format:
The first line of input contains two integers N (number of rows) and M (number of columns) of the binary matrix.
The second line of input contains N*M space-separated elements of the binary matrix.
Output Format:
The only output line contains a single integer which will be the maximum area possible of sub-matrix of all 1's.
Sample Input:
4 5
0 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0
Sample Output:
10
Explanation:
The matrix for the above Sample Input is:
0 1 0 0 0
1 1 1 1 1
1 1 1 1 1
1 0 0 0 0

The maximum size rectangle in this binary matrix is:
1 1 1 1 1
1 1 1 1 1

So, the area of the rectangle is=5*2=10

     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M =s.nextInt();
        int[][] arr = new int[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++) arr[i][j]=s.nextInt();
        }
        System.out.println(maxRecArea(N, M, arr));

    }

    private static int maxRecArea(int N,int M,int[][] arr){
        if (N==0 || M == 0) return 0;
        int ans = Area(M,arr[0]);
        for (int i =1;i<N;i++){
            for (int j =0;j<M;j++){
                if (arr[i][j] == 1){
                    arr[i][j]+=arr[i-1][j];
                }

            }
            ans = Math.max(ans,Area(M,arr[i]));
        }
        return ans;
    }

    private static int Area(int M,int[] n){
        Stack<Integer> res = new Stack<>();
        int top_one ;
        int maxA = 0;
        int area =0;
        int i=0;
        while (i<M) {
            if (res.empty() || n[res.peek()] <= n[i]) {
                res.push(i++);
            } else {
                top_one = n[res.peek()];
                res.pop();
                area = top_one * i;

                if (!res.empty()) {
                    area = top_one * (i - res.peek() - 1);
                }
                maxA = Math.max(area, maxA);
            }
        }
        while (!res.empty()){
            top_one = n[res.peek()];
            res.pop();
            area = top_one * i;

            if (!res.empty()) {
                area = top_one * (i - res.peek() - 1);
            }
            maxA = Math.max(area,maxA);
        }
        return maxA;


    }
}
