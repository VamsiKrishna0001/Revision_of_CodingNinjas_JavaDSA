package Group2_set4;

import java.util.Scanner;

public class GroupSum {

    static boolean subsetSumToKIdentical(int input[], int n, int k) {
        for (int i = 0; i < (n - 1); i++) {
            for (int j = (i + 1); j < n; j++) {
                if (input[i] + input[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String [] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0;i < n; i++)
            input[i] = s.nextInt();
        int k = s.nextInt();
        if(subsetSumToKIdentical(input,n,k))
            System.out.println("true");
        else
            System.out.println("false");
    }

}
