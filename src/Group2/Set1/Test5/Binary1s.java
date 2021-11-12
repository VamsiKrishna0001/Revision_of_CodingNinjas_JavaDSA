package Group2.Set1.Test5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Binary1s {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();

            ArrayList<String> res = generateString(n);
            for (String i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void generateStringHelper(int k, char str[], int n, ArrayList<String> ans) {
        if (n == k) {
            ans.add(new String(str));
            return;
        }
        if (str[n - 1] == '1') {
            str[n] = '0';
            generateStringHelper(k, str, n + 1, ans);
        }
        if (str[n - 1] == '0') {
            str[n] = '0';
            generateStringHelper(k, str, n + 1, ans);
            str[n] = '1';
            generateStringHelper(k, str, n + 1, ans);
        }
    }

    public static ArrayList<String> generateString(int k) {
        ArrayList<String> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }
        char str[] = new char[k];
        str[0] = '0';
        generateStringHelper(k, str, 1, result);
        str[0] = '1';
        generateStringHelper(k, str, 1, result);
        Arrays.sort(str);
        return result;
    }
}
