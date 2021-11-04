package Group4;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class whiteSubtreee {
    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        public InputReader(InputStream st) {
            this.stream = st;
        }
        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public int[] nia(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }
        public String rs() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
    public static class Key {

        private final int x;
        private final int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }

    static PrintWriter w = new PrintWriter(System.out);
    static long mod=998244353L,mod1=1000000007;
    static int co[][];
    static void dsort(){
        Arrays.parallelSort(co,(o1, o2)->o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]);
    }
    static class Pair{
        int w,b;
        public Pair(int w,int b){
            this.b=b;
            this.w=w;
        }
    }
    static int c[],dp[],n,ans[];
    static ArrayList<Integer> arr[];
    static int dfs(int i,int p){
        int di=-1;
        if(c[i]==1)di=1;
        for(int j:arr[i]){
            if(j!=p){
                di+=(Math.max(0,dfs(j,i)));
            }
        }

        return dp[i] =di;
    }
    static void dfs1(int i,int p){
        for(int j:arr[i]){
            if(j!=p){
                if(dp[j]<0){
                    dp[j]+=Math.max(0,dp[i]);
                }
                else{
                    dp[j]+=Math.max(0,dp[i]-dp[j]);
                }
                dfs1(j,i);
            }
        }
    }
    public static void main (String[] args)throws IOException {
        InputReader sc=new InputReader(System.in);
        n=sc.ni();
        c=new int[n+1];
        dp=new int[n+1];
        ans=new int[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            c[i]=sc.ni();
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int u=sc.ni(),v=sc.ni();
            arr[u].add(v);
            arr[v].add(u);
        }
        dfs(1,1);
        dfs1(1,1);
        for(int i=1;i<=n;i++){
            w.print(dp[i]+" ");
        }
        w.println();
        w.close();
    }
}
