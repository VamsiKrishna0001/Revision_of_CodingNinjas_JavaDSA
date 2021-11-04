package Group4.set2;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/*
Jack Ryan is one of the world’s most famous cryptographers. He has been recently tasked with breaking a code with which our country’s enemies are communicating. He has thought of a possible break in the code, using a very complex system of strings, which thankfully, you have nothing to do with. You are tasked with a little problem. Jack will give you n strings, labelled S1, S2, …. Sn, along with q queries.
In each query, you have an integer X and a string CODE. You will take into consideration strings S1 to SX. Among these selected strings, consider all the strings such that their longest common prefix with CODE is the maximum possible. Now, from these strings, print the lexicographically smallest one. This would give Jack tremendous insight into further breaking the code. Can you help him?
Input Format:
The first line of the input contains a single integer N.
N lines follow. For each valid i, the i-th of these lines contains Chef's string Si.
The next line contains a single integer Q.
The following Q lines describe queries. Each of these lines contains an interger R, followed by a space and a string P
Constraints:
1 ≤ n ≤ 100,000
1 ≤ |Si| ≤ 10 for each valid i
1 ≤ q ≤ 100,000
1 ≤ X ≤ n
1 ≤ |CODE| ≤ 10
Output Format:
For each query, print a single line containing the string that satisfies the required conditions — the answer to that query.
Sample Input 1:
4
abcd
abce
abcdex
abcde
3
3 abcy
3 abcde
4 abcde
Sample Output 1:
abcd
abcdex
abcde
 */
public class CodeBreaker {
    static Trie root;

    static class Trie {
        Trie ch[] = new Trie[26];
        int id;
        int Minval;
        boolean isEnd;

        Trie() {
            Minval = 1000001;
            isEnd = false;
            for (int i = 0; i < 26; i++)
                ch[i] = null;
            this.id = -1;
        }
    }

    static void insert(String value, int index) {
        Trie node = root;
        for (int i = 0; i < value.length(); i++) {
            int ind = value.charAt(i) - 'a';
            if (node.ch[ind] == null) {
                node.ch[ind] = new Trie();

                node.ch[ind].Minval = index;
            }

            node = node.ch[ind];
        }
        node.isEnd = true;
        if (node.id == -1)
            node.id = index;
    }

    static String search(String value, int r) {
        Trie node = root;
        String s = "";
        int ind = 0;
        for (int i = 0; i < value.length(); i++) {
            ind = value.charAt(i) - 'a';
            if (node.ch[ind] != null) {
                if (node.ch[ind].Minval <= r) {
                    s += value.charAt(i);
                } else
                    break;
            } else {
                break;

            }
            node = node.ch[ind];
        }

        while (node != null) {
            if (node.isEnd == true && node.id <= r)
                return s;
            else {
                for (int i = 0; i < 26; i++) {
                    if (node.ch[i] != null && node.ch[i].Minval <= r) {
                        node = node.ch[i];
                        s += (char) (i + 'a');
                        break;
                    }
                }
            }
        }

        return s;

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception r) {
                r.printStackTrace();
            }
            return str;
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        FastReader in = new FastReader();
        root = new Trie();
        int n = in.nextInt();
        for (int i = 1; i <= n; i++)
            insert(in.next(), i);

        int q = in.nextInt();
        while (q-- > 0) {
            int r = in.nextInt();
            String s = in.next();
            System.out.println(search(s, r));

        }


    }

}

