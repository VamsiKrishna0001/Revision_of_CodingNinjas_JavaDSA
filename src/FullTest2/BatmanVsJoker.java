package FullTest2;

import java.util.Scanner;
import java.util.Stack;

public class BatmanVsJoker {
    /*
    Gotham has been attacked by Joker . Bruce Wayne has deployed automatic machine gun at each tower of Gotham.
All the towers in Gotham are in straight line.
You are given no of towers 'n' followed by height of 'n' towers.
For every tower(p), find the height of the closest tower (towards the right), greater than the height of tower(p).
Now , Print sum of all such heights (mod 1000000007).
Note : If for a tower(k) , no such tower exsits then take its height as 0.
Input Format:
First line contains 'n' denoting no of towers.
This is followed by 'n' spaced integers h1,h2.....h(n) representing height of towers.
Output Format:
On a single line, output the sum(mod 1000000007).
Constraints:
1<=n<=100000
0<=h[i]<=100000
Sample Input:
9
112 133 161 311 122 512 1212 0 19212
Sample Output:
41265


     */

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=s.nextInt();
        }
        s.close();
        Stack<Integer> ss = new Stack<Integer>();
        int sum =0,mod = 1000000007;
        for(int i=0;i<n;i++){
            if(!ss.isEmpty() && arr[i]>ss.peek()){
                while(!ss.isEmpty() && arr[i]>ss.peek()){
                    ss.pop();
                    sum=(sum+arr[i])%mod;
                }
            }
            ss.push(arr[i]);
        }
        System.out.println(sum);
    }
}
