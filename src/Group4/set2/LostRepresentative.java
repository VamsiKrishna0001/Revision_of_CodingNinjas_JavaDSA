package Group4.set2;

import java.io.*;
import java.util.*;
/*
The Government Public School of Wadiya city is holding a congress of students. The number of representations from each grade is equal to the grade number. From the first grade, the congress has only 1 representative, from the second grade, the congress has only 2 representatives and so on and so forth. All the representatives are told to assemble in the main ground. All the same grade representatives are standing together.
A representative of grade P comes to the stage and says that he is unable to find his group of representatives. The organisers are busy with other tasks. You have to find the group for the lost representative.
The main ground is a huge N*N matrix. You are given this matrix as input. Each representative occupies a cell. An occupied cell is represented by integer 1 and an unoccupied cell by integer 0. All the representatives of the same grade are connected to each other and disconnected from other grade representatives. An occupied cell is said to be connected to those occupied cells which are reachable from its cell. A representative can move across to other occupied cells with which it shares its edges.
For example:
Alt Text
In this diagram of a part of the ground, red coloured cells represents the connected group of sixth grade students, yellow cell represents the connected group of first grade student and green represents the connected group of fourth grade students.
You will be given the matrix and you have to find the starting cell of the connected group of the lost representative.
Starting Cell is the one with the lowest row value. (If row number of two or more cells is same, then starting cell among them is the one with lowest column value)
It may be possible that the representative may be confused, and the grade he says he is from is actually not present. In that case, print starting cell as -1 -1.
Input Format:
First line of input contains integer t, representing the number of test cases.
First line of each test case contains integer n, representing the size of the matrix.
The second line onwards, the next 'N' lines or rows represent the ith row values.
Each of the ith rows constitutes 'N' column values separated by a single space.
Last line of each test case contains integer p, representing the grade of the lost representative.
Constraints:
1 <= N <= 1000
1 <= p <= 100
Output Format:
For each test case, you need to print the starting cell of the connected group of the lost representative.
Sample Input 1:
1
5
1 1 0 0 0
0 1 0 0 1
1 1 0 1 1
0 0 0 0 0
1 1 0 0 1
3
Sample Output 1:
1 4
Explanation:
The lost representative is from the 3rd grade. In the given matrix, the 3rd grade is represented by the cluster of 1s where the starting cell of this cluster is 1,4.
 */

public class LostRepresentative {
    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValid(int n, int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    public static void main(String[] args) throws IOException {
        Test sc = new Test();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                mat[i] = sc.nextIntArray(n);
            }
            boolean[][] isVisited = new boolean[n][n];
            HashMap<Integer, Cell> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j] && mat[i][j] == 1) {
                        Cell startcell = new Cell(i, j);
                        Queue<Cell> q = new LinkedList<>();
                        q.add(startcell);
                        isVisited[i][j] = true;
                        int count = 1;

                        while (!q.isEmpty()) {
                            Cell thiscell = q.remove();
                            if (isValid(n, thiscell.x + 1, thiscell.y) && mat[thiscell.x + 1][thiscell.y] == 1 && !isVisited[thiscell.x + 1][thiscell.y]) {
                                q.add(new Cell(thiscell.x + 1, thiscell.y));
                                count++;
                                isVisited[thiscell.x + 1][thiscell.y] = true;
                            }
                            if (isValid(n, thiscell.x - 1, thiscell.y) && mat[thiscell.x - 1][thiscell.y] == 1 && !isVisited[thiscell.x - 1][thiscell.y]) {
                                q.add(new Cell(thiscell.x - 1, thiscell.y));
                                count++;
                                isVisited[thiscell.x - 1][thiscell.y] = true;
                            }
                            if (isValid(n, thiscell.x, thiscell.y + 1) && mat[thiscell.x][thiscell.y + 1] == 1 && !isVisited[thiscell.x][thiscell.y + 1]) {
                                q.add(new Cell(thiscell.x, thiscell.y + 1));
                                count++;
                                isVisited[thiscell.x][thiscell.y + 1] = true;
                            }
                            if (isValid(n, thiscell.x, thiscell.y - 1) && mat[thiscell.x][thiscell.y - 1] == 1 && !isVisited[thiscell.x][thiscell.y - 1]) {
                                q.add(new Cell(thiscell.x, thiscell.y - 1));
                                count++;
                                isVisited[thiscell.x][thiscell.y - 1] = true;
                            }
                        }

                        hash.put(count, startcell);
                    }
                }
            }

            int r = sc.nextInt();
            if (hash.containsKey(r))
                System.out.println((hash.get(r).x) + " " + (hash.get(r).y));
            else System.out.println("-1 -1");
        }

        sc.close();
    }

    static class Test {
        final private int BUFFER_SIZE = 1 << 18;
        final private DataInputStream din;
        final private byte[] buffer;
        private PrintWriter pw;
        private int bufferPointer, bytesRead;
        StringTokenizer st;

        public Test() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public void println(String a) {
            pw.println(a);
        }

        public void print(String a) {
            pw.print(a);
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            return arr;
        }


        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
            if (pw != null) pw.close();
        }
    }

}
