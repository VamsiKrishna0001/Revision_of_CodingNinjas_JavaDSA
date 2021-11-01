package Group2_set4;

public class PossibleCombination {


    static void cobination(int arr[], int data[], int start, int end, int indices, int N) {
        if (indices == N) {
            for (int j=0; j<N; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= N-indices; i++) {
            data[indices] = arr[i];
            cobination(arr, data, i+1, end, indices+1, N);
        }
    }

    static void PossibleComb(int arr[], int n, int N) {

        int data[]=new int[N];
        cobination(arr, data, 0, n-1, 0, N);
    }
    public static void main (String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int r = 12;
        int n = arr.length;
        PossibleComb(arr, n, r);
    }
}
