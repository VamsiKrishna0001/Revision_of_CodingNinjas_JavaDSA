package Group2.Set1.Test2;

import java.util.Scanner;

public class FindM {
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

    }
    static int findPath(char[][] matrix,String word){
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        for (int i=0;i<len1;i++){
            for (int j=0;j<len2;j++){

            }
        }
        return 1;
    }
}
