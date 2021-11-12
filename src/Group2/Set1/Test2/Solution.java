package Group2.Set1.Test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Node
{
    public int x, y;

    private Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Node of(int x, int y) {
        return new Node(x, y);
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }
}
public class Solution {
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = {  0,-1, 1, 0 };
    static int cnt=0;
    public static boolean isValid(Node next, List<Node> path, int M, int N) {
        return (next.x >= 0 && next.x < M) && (next.y >= 0 && next.y < N) &&
                !path.contains(next);
    }
    public static void DFS(char[][] mat, String word, Node next, List<Node> path, int index) {
        int i = next.x;
        int j = next.y;
        if (mat[i][j] != word.charAt(index)) {
            return;
        }
        path.add(Node.of(i, j));
        if (index == word.length() - 1) {
            cnt++;
            System.out.println(path);
        } else {
            for (int k = 0; k < row.length; k++) {
                next = Node.of(i + row[k], j + col[k]);
                if (isValid(next, path, mat.length, mat[0].length)) {
                    DFS(mat, word, next, path, index + 1);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    public static int findPath(char[][] inputMatrix, String target) {
        if (inputMatrix == null || inputMatrix.length == 0 || target == null) {
            return cnt;
        }

        List<Node> path = new ArrayList<>();
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                DFS(inputMatrix, target, Node.of(i, j), path, 0);
            }
        }
        return cnt;
    }
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
        }
        System.out.println(findPath(matrix, s.next()));
    }
}
