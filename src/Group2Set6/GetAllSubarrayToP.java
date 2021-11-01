package Group2Set6;

public class GetAllSubarrayToP {
    /*
    A sequence of integers N1, N2, N3, .... Nm. This sequence can generate an integer P, only if it is possible to find another sequence of integers: O1, O2, O3 .... Om such that:
Equation (1) -> O1 * N1 + O2 * N2 + .... Om * Nm = P
For this problem, you are given a sequence of n integers, T1, T2, T3, T4 ... Tn, and on this sequence, you are asked x queries. In each query, you are given an integer P, the solution to each query is count of all subarrays (each subarray is defined by indices [i, j], where i and j are inclusive) such that the integers in the subarray T[i], T[i+1] .... T[j] generates P, according to the equation 1.
Input Format:
The first line of input contains a single integer, that denotes the value of n. The value of n lies in the range: [1, 100000]. The following line of input contains n space separated integers. The value of each integer lies in the range [1, 1000000000]. The following line of input contains number of queries, that denotes the value of x. The value of x lies in the range [1, 100000]. The following x lines, contain a single integer P. The value P lies in the range [1, 1000000].
Constraints:
Time Limit: 1 second
Output format:
There are x lines of output in each query. For each of the x lines, print the count of subarrays that generate P.
Sample Input 1:
4
2 4 3 6
3
1
2
3
Sample Output 1:
4
6
6
Explanation:
For the first query, the four subarrays are: [4,3], [2, 4, 3], [4, 3, 6], [2, 4, 3, 6].
For the second query, the six subarrays are: [4,3], [2, 4, 3], [4, 3, 6], [2, 4, 3, 6], [2], [2, 4].
For the first query, the four subarrays are: [4,3], [2, 4, 3], [4, 3, 6], [2, 4, 3, 6], [3], [3, 6].
     */
}
