package FullTest2;

import java.util.Arrays;
import java.util.Scanner;

public class AppleCost {
/*
You went to a fruit store to purchase some apples. Each apple has its own price. There is an offer going on at the store that buy three apples and get the least cost one for free.
For example, let the prices of the apples be: 10 3 2 4 6 4 9. If you arrange them into groups: (10, 3, 2), (4, 6, 4) and (9), you would get the apples priced 2 from the first group for free and the apple priced 4 from the second group. You won’t get anything for free from the third group because it contains only one apple.
Your task is to minimize the cost of apples.
Input Format:
The first line of input contains the integer N, the number of apples to be bought.
Each of the following N lines contains a single integer Ci, the price of each apple.
Constraints:
1 ≤ N ≤ 100000
1 ≤ Ci ≤ 100000
Time limit : 1 sec
Output Format:
The first and only line of output must contain the required minimal price.
Sample Input 1:
4
3
2
3
2
Sample Output 1:
8
Explanation:
Make 2 triplets (3,3,2) and (2) in first group 2 is for free so total cost is 3+3+2=6.
 */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int apples[] = new int[n];
        for(int i=0;i<n;i++){
            apples[i] = s.nextInt();

        }
        Arrays.sort(apples);
        int grp = n-3;
        int price = 0;
        while(grp>=0){
            price+=apples[grp+1]+apples[grp+2];
            grp-=3;
        }
        grp+=2;
        if(grp>0){
            price+=apples[0]+apples[1];
        }else if(grp == 0){
            price+=apples[0];
        }
        System.out.println(price);
    }
}
