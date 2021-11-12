package Group2.Set1.Test2;

import java.util.Scanner;

public class find2 {
    // Java program to check if the word
// exists in the grid or not
    static class GFG
    {

//        static final int r = 4;
//        static final int c = 4;

        // Function to check if a word exists in a grid
// starting from the first match in the grid
// level: index till which pattern is matched
// x, y: current position in 2D array
       static int findmatch(char mat[][], String pat, int x, int y,
                                 int nrow, int ncol, int level)
        {
            int cnt=0;
            int l = pat.length();

            // Pattern matched
            if (level == l)
                return cnt++;

            // Out of Boundary
            if (x < 0 || y < 0 || x >= nrow || y >= ncol)
                return cnt;

            // If grid matches with a letter while
            // recursion
            if (mat[x][y] == pat.charAt(level))
            {

                // Marking this cell as visited
                char temp = mat[x][y];
                mat[x][y] = '#';

                // finding subpattern in 4 directions
                int res = findmatch(mat, pat, x - 1, y, nrow, ncol, level + 1) |
                        findmatch(mat, pat, x + 1, y, nrow, ncol, level + 1) |
                        findmatch(mat, pat, x, y - 1, nrow, ncol, level + 1) |
                        findmatch(mat, pat, x, y + 1, nrow, ncol, level + 1);

                // marking this cell
                // as unvisited again
                mat[x][y] = temp;
                return res;
            }
            else // Not matching then false
                return cnt;
        }

        // Function to check if the word exists in the grid or not
        static int checkMatch(char mat[][], String pat, int nrow, int ncol)
        {
            int cnt=0;
            int l = pat.length();

            // if total characters in matrix is
            // less then pattern lenghth
            if (l > nrow * ncol)
                return cnt;

            // Traverse in the grid
            for (int i = 0; i < nrow; i++)
            {
                for (int j = 0; j < ncol; j++)
                {

                    // If first letter matches, then recur and check
                    if (mat[i][j] == pat.charAt(0)) {
                        int cc = findmatch(mat, pat, i, j, nrow, ncol, 0);
                        cnt+=cc;
                    }
                }
            }
            return cnt;
        }

        // Driver Code

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int matrixRow = s.nextInt();
        String[] input = new String[matrixRow];
        for(int i=0;i<matrixRow;i++){
            input[i] = s.next();//string lengths may be different
        }
        char[][] matrix = new char[matrixRow][];
        for(int i = 0;i<matrixRow;i++){
            matrix[i] = new char[input[i].length()];
            for(int j=0;j<input[i].length();j++){
                matrix[i][j] = input[i].charAt(j);
            }
        }
        int r = matrixRow;
        int   d = input[0].length();

        int x =GFG.checkMatch(matrix, "to",r,d);
        System.out.println(x);

    }

// This code is contributed by 29AjayKumar

}
