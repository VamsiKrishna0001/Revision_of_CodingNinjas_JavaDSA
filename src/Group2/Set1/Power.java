package Group2.Set1;

import java.util.Scanner;

public class Power {
//    public static int Power(int a, int[] b){
//
//        int l = b.length;
//        int mod = 1337;
//        int[] pwr = new int[l];
//        pwr[l-1] = a%mod;
//        for(int i=l-2; i>=0; i--){
//            pwr[i] = power(pwr[i+1],10,mod);
//        }
//        int res = 1;
//        for(int i=0; i<l; i++){
//            int temp = power(pwr[i], b[i], mod);
//            res = (temp * res)%mod;
//        }
//        return Long.valueOf(res).intValue();
//    }
    public static int Power(int a, int[] b) {
        int[] buf = new int[10];
        buf[0] = 1;
        a = a%1337;
        for(int i =1;i<10;i++){
            buf[i] = (buf[i-1]*a)%1337;
        }
        int res = buf[b[0]], temp;
        for(int i = 1;i<b.length;i++){
            res = (res*res)%1337;
            temp = res;
            res = (res*res)%1337;
            res = (res*res)%1337;
            res = (res*temp)%1337;
            res = (res*buf[b[i]])%1337;
        }
        return res;
    }
    public static int power(int x, int n, int mod){
        if(n==0)return 1;
        if(n == 1)return x%mod;
        int half = power(x,n/2,mod);
        int extra = n%2==1?x:1;
        return (((half*half)%mod)*(extra%mod))%mod;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int n =s.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) arr[i]=s.nextInt();
        System.out.println(Power(a,arr));
    }

}
