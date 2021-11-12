package Group2.Set1.Test2;

import java.util.Scanner;

public class pf {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = s.nextInt();
        while (n>0){
            System.out.println(pfr(str, s.nextInt(), s.nextInt()));
            n--;
        }
//        String ss = "heleltronrocop";
//        int a=1,b=3;
//        String st="";
//        for (int j=a;j<=b;j++){
//            st+= ss.charAt(j);
//        }
//        System.out.println(st);
    }
    static String pfr(String word,int a,int b){
    String st =newString(word,a,b);
    char[] ch = st.toCharArray();
    int len = ch.length;
    if (len%2 == 0){
        int c = len/2;
        int sum=0,sum1=0;
        for (int i=0;i<c;i++){
            sum+=(int)(ch[i]);
        }
        for (int i=c;i<len;i++){
            sum1+=(int)(ch[i]);
        }
        if (sum == sum1){
            return "Yes";
        }
    }else {
        int d=len/2;
        int sum=0,sum1=0;
        for (int i=0;i<d;i++){
            sum+=ch[i];
        }
        for (int i=d+1;i<len;i++){
            sum1+=ch[i];
        }
        if (sum == sum1){
            return "Yes";
        }
    }
    return "No";

    }
    static String newString(String word,int a,int b){
        String st = "";
        for (int j=a;j<=b;j++){
            st+= word.charAt(j);
        }
        return st;
    }

}
