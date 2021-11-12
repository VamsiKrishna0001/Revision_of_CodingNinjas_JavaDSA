package Group2.Set1.Test2;

import java.io.*;

public class PQ {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[110000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static class Item implements Comparable<Item> {
        int l, r;
        @Override public int compareTo(Item item) {
            if (this.r < item.r) {
                return -1;
            } else if (this.r > item.r) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static int bit[][], n;

    static void update(int idx, char ch) {
        for (; idx <= n; idx += (idx & -idx)) {
            ++bit[idx][ch - 'a'];
        }
    }

    static int[] read(int idx) {
        int temp[] = new int[26];
        for (; idx > 0; idx -= (idx & -idx)) {
            for (int i = 0; i < 26; ++i) {
                temp[i] += bit[idx][i];
            }
        }
        return temp;
    }

    public static void main(String args[]) throws IOException {
        Reader rd = new Reader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q, l, r, i, oddCount;
        char arr[] = rd.readLine().toCharArray();
        q = rd.nextInt();
        n = arr.length;
        bit = new int[n + 1][26];
        for (i = 1; i <= n; ++i) {
            update(i, arr[i - 1]);
        }
        while (--q >= 0) {
            l = rd.nextInt();
            r = rd.nextInt();
            int left[] = read(l - 1);
            int right[] = read(r);
            for (i = oddCount = 0; i < 26; ++i) {
                right[i] -= left[i];
                if ((right[i] & 1) != 0) {
                    ++oddCount;
                }
            }
            if (oddCount <= 1) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }

        }
        bw.close();
    }
}
