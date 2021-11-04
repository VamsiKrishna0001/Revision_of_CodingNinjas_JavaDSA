package Group4.set2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given an array of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of the array, and a != b != c != d.
Input Format:
First line of input contains an integer N, representing the number of elements in array
Second line of input contains N space separated integers
Output Format:
Print the required count
Sample Input 1:
4
2 3 4 6
Sample Output 1:
8
Explanation:
There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 */
public class SameProduct {
    public static void main(String[] args) {
        // Take input as instructed
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++) arr[i] = s.nextInt();
        // Print output as instructed
        System.out.println(tupleSameProduct(arr));

    }

    public static int tupleSameProduct(int[] num) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num.length;i++){
            for(int j=i;j<num.length;j++){
                if(i!=j){
                    int product=num[i]*num[j];
                    map.put(product,map.getOrDefault(product,0)+1);
                }
            }
        }

        int count=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int value=m.getValue();
			/*if count of the pair multiplication is greater than 2 than tuple is found
			now if count is say 3 so P1,P2,P3 are three pairs means P1 consists of two
			elements and similary P2 and P3. Now we can arrange P1,P2 and P3 in two positions
			using 6 ways simple combinations and let's say P1,P2 and P1 and P2 consists of two
			elements each which can further be arranged in 4 ways */
            if(value>=2){
                int changes=(value)*(value-1);
                count=count+(4*changes);
            }
        }
        return count;

    }
}
