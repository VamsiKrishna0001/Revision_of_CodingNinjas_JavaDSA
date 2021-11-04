package Group2.Set1;

public class BinaryPlay {
    static public int binarySequence(int N, int X) {
        String str1 = "0";
        String str2 = "0";
        for (int j = 0; j < N-1; j++) {
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i)=='0') str2+='1';
                if(str1.charAt(i)=='1') str2+='0';
            }
            str1= str2;
            System.out.println(str1);

            if(str1.length()>=X){
               break;
            }
          //  System.out.println(a);
        }
        return str1.charAt(X-1)-'0';
//        String str1 = "0", str2="0";
//        int a = str1.length();
//        int i=0;
//        while(i<N-1){
//            int j=0;
//            while(j<a){
//                if(str1.charAt(j)=='0') str2+='1';
//                if(str1.charAt(j)=='1') str2+='0';
//                j++;
//            }
//            i++;
//            str1 = str2;
//            if(a>=X) break;
//        }
//        return str1.charAt(X-1)-'0';
    }
    public static void main(String[] args) {
        System.out.println(binarySequence(4, 5));
    }
}
