package Group2.Set1;

public class AllPossibleways {
    static int cnt = 0;

    static int Allways(int num, int x, int k, int n) {
        if (x == 0) cnt++;
        int l = (int) Math.floor(Math.pow(num, 1.0 / n));

        for (int i = k + 1; i <= l; i++) {
            int a = x - (int) Math.pow(i, n);
            if (a >= 0)
                Allways(num, x - (int) Math.pow(i, n), i, n);
        }
        return cnt;
    }

    // Wrapper over checkRecursive()
    static int allWays(int x, int n) {
        return Allways(x, x, 0, n);
    }

    public static void main(String[] args) {
        System.out.println(allWays(100, 2));
    }
}
