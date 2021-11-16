package Lecture23_Queues.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKelementa {
    /*
    For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.
Example:
alt txt
For the above input queue, if K = 4 then after reversing the first 4 elements, the queue will be updated as:
alt txt
Input Format :
The first line of input would contain two integers N and K, separated by a single space. They denote the
total number of elements in the queue and the count with which the elements need to be reversed respectively.

The second line of input contains N integers separated by a single space, representing the order in
which the elements are enqueued into the queue.
Output Format:
The only line of output prints the updated order in which the queue elements are dequeued, all of them
separated by a single space.
Note:
You are not required to print the expected output explicitly, it has already been taken care of. Just make
the changes in the input queue itself.
Contraints :
1 <= N <= 10^6
1 <= K <= N
-2^31 <= data <= 2^31 - 1

 Time Limit: 1sec
Sample Input 1:
5 3
1 2 3 4 5
Sample Output 1:
3 2 1 4 5
Sample Input 2:
7 7
3 4 2 5 6 7 8
Sample Output 2:
8 7 6 5 2 4 3
     */

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
        String[] n_k = br.readLine().trim().split(" ");

        int n = Integer.parseInt(n_k[0]);
        int k = Integer.parseInt(n_k[1]);

        String[] values = br.readLine().trim().split(" ");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(values[i]));
        }

        return new Input(n, k, queue);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Input input = takeInput();

        int n = input.n;
        int k = input.k;
        Queue<Integer> queue = input.queue;

        queue = reverseKElements(queue, k);


        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    private static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        if (input.isEmpty() || k>input.size() || k<=0) return input;
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<k;i++){
            st.push(input.poll());
        }
        while (!st.isEmpty()) input.add(st.pop());
        for (int i=0;i<input.size()-k;i++){
            input.add(input.poll());
        }
        return input;
    }
}
class Input {
    int n;
    int k;
    Queue<Integer> queue;

    public Input(int n, int k, Queue<Integer> queue) {
        this.queue = queue;
        this.n = n;
        this.k = k;
    }

}

