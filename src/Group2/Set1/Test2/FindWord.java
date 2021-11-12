package Group2.Set1.Test2;

import java.util.Scanner;

public class FindWord {
    static int R, C;

    // For searching in all 8 direction
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // This function searches in all 8-direction from point
    // (row, col) in grid[][]
    static boolean search2D(char[][] grid, int row,
                            int col, String word) {
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row,col)
        for (int dir = 0; dir < 8; dir++)
        {
            // Initialize starting point
            // for current direction
            int k, rd = row + x[dir], cd = col + y[dir];

            // First character is already checked,
            //  match remaining characters
            for (k = 1; k < len; k++)
            {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;

                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;

                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }

            // If all character matched, then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }

    // Searches given word in a given
    // matrix in all 8 directions
    static int findPath(char[][] grid, String word) {
        int cnt=0;
        // Consider every point as starting
        // point and search given word
        for (int row = 0; row < R; row++)
        {
            for (int col = 0; col < C; col++)
            {
                if (search2D(grid, row, col, word)) {
                    System.out.println("pattern found at " + row + ", " + col);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // Driver code
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
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
            R = matrixRow;
            C = input[0].length();
        }
        System.out.println(findPath(matrix, s.next()));

    }
}
