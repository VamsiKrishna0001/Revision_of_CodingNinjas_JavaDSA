package Group1;

import java.util.Scanner;

public class NumberStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp =n,numstar=0;
        while(temp>0){
            int i = 1,j=n;
            while (j > 0) {
                if (i<=temp){
                    System.out.print(i);
                    i++;
                }
                j--;
            }
            int star=1;
            while (star<=numstar){
                System.out.print("*");
                star++;
            }
            int k=n,l=n;
            while(k>0){
                if (k<=temp){
                    System.out.print(k);
                }
                k--;
            }
            System.out.println();
            temp--;
            numstar+=2;
        }
    }
}
