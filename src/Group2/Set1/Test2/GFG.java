package Group2.Set1.Test2;

/* A Java program to answer queries to check whether
the substrings are palindrome or not efficiently */

// Java Program to find all occurrences of the word in
// a matrix

// Java program to search
// a word in a 2D grid

class GFG
{

    // Query type 1: update string
    // position i with character x.
    static void qType1(int l, int x, char str[])
    {
        str[l - 1] = (char) x;
    }

    // Print "Yes" if range [L..R] can form
    // palindrome, else print "No".
    static void qType2(int l, int r, char str[])
    {
        int freq[] = new int[27];

        // Find the frequency of each
        // character in S[L...R].
        for (int i = l - 1; i <= r - 1; i++)
        {
            freq[str[i] - 'a']++;
        }

        // Checking if more than one character
        // have frequency greater than 1.
        int count = 0;
        for (int j = 0; j < 26; j++)
        {
            if (freq[j] % 2 != 0)
            {
                count++;
            }
        }
        if (count <= 1)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

    // Driven code
    public static void main(String[] args)
    {
        char str[] = "heleltronrocop".toCharArray();
        int n = str.length;

        qType2(1, 3, str);
        qType2(0, 4, str);
        qType1(6, 10, str);
    }
}
// This code is contributed by rachana soma


// Node class
//class Node
//{
//    public int x, y;
//
//    private Node(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public static Node of(int x, int y) {
//        return new Node(x, y);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        Node node = (Node) o;
//        return x == node.x && y == node.y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }
//
//    @Override
//    public String toString() {
//        return ("(" + x + ", " + y + ")");
//    }
//}

//class Main
//{
//    // Below arrays detail all eight possible movements from a cell
//    private static final int[] row = { -1, 0, 0, 1 };
//    private static final int[] col = {  0,-1, 1, 0 };
//
//    // Function to check if it is possible to go to position next
//    // from the current position. The function returns false if next is
//    // not in a valid position, or it is already visited
//    public static boolean isValid(Node next, List<Node> path, int M, int N) {
//        return (next.x >= 0 && next.x < M) && (next.y >= 0 && next.y < N) &&
//                !path.contains(next);
//    }
//    static int cnt=0;
//    public static void DFS(char[][] mat, String word, Node next,
//                           List<Node> path, int index) {
//        int i = next.x;
//        int j = next.y;
//        if (mat[i][j] != word.charAt(index)) {
//            return;
//        }
//        path.add(Node.of(i, j));
//        if (index == word.length() - 1) {
//            cnt++;
////            System.out.println(path);
//        } else {
//            for (int k = 0; k < row.length; k++) {
//                next = Node.of(i + row[k], j + col[k]);
//                if (isValid(next, path, mat.length, mat[0].length)) {
//                    DFS(mat, word, next, path, index + 1);
//                }
//            }
//        }
//        path.remove(path.size() - 1);
//    }
//
//    public static int findAllOccurences(char[][] mat, String word) {
//        // base case
//        if (mat == null || mat.length == 0 || word == null) {
//            return cnt;
//        }
//
//        List<Node> path = new ArrayList<>();
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                DFS(mat, word, Node.of(i, j), path, 0);
//            }
//        }
//       return cnt;
//    }
//
//    public static void main(String[] args)
//    {
////        char mat[][] =
////                {
////                        "DEMXB".toCharArray(),
////                        "AOEPE".toCharArray(),
////                        "DDCOD".toCharArray(),
////                        "EBEDS".toCharArray(),
////                        "CPYEN".toCharArray()
////
////                };
////
//        String word = "to";
//        Scanner s = new Scanner(System.in);
//        int matrixRow = s.nextInt();
//        String[] input = new String[matrixRow];
//        for(int i=0;i<matrixRow;i++){
//            input[i] = s.next();//string lengths may be different
//        }
//        char[][] matrix = new char[matrixRow][];
//        for(int i = 0;i<matrixRow;i++){
//            matrix[i] = new char[input[i].length()];
//            for(int j=0;j<input[i].length();j++){
//                matrix[i][j] = input[i].charAt(j);
//            }
//        }
//
//        //System.out.println(findAllOccurences(matrix, word));
//        System.out.println(Solution.findPath(matrix,word));
//    }
//}

