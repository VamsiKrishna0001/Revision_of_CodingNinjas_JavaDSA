package Group2_set4;

import java.util.Scanner;

public class WaterNJugs {
    /*

     */

    static String solve(int a, int b, int c) {
        if(c%gcd(a,b)==0 && c<=Math.max(a,b))
            return "YES";

        return "NO";

    }

//    static int gcd(int a,int b){
////        if(b==0)
////            return a;
////        return gcd(b,a%b);
//        int tmp;
//        while(a%b!=0)
//        {
//            tmp=a%b;
//            a=b;
//            b=tmp;
//        }
//        return b;
//    }

    public static String WaternJug(int john, int zeus, int peter) {
        if(john + zeus < peter)
            return "No";
        if(peter%gcd(john,zeus) == 0)
            return "Yes";
        return "No";
    }

    public static int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        while (n!=0){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            System.out.println(WaternJug(a,b,c));
            n--;
        }

    }
}
