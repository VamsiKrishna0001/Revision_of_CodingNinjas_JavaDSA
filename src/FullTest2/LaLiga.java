package FullTest2;

import java.util.Scanner;

public class LaLiga {
    /*
    This is Super - Sunday for football fans. It is the final night. It is Barcelona vs Real Madrid. Moreover, the talking point of this year's La liga is Sevilla becoming the last team to qualify for the playoffs with just 12 points.
The question is if 'N' teams are playing in the La Liga, what is the minimum number of points at which a team may qualify for a play off?
Note: 1. You have to workaround a solution in the premises of the format, where a winning team is awarded 2 points and losing team is awarded 0 points. 4 teams qualify for the playoffs, after league stage where each team plays all the other teams once.
2. We have to assume all the matches arrive to a result. (no draw)
Input format:
The first and only line of input contains N, that denotes number of teams which are participating in the League. The value of N lies in the range: [5, 100000].
Constraints:
Time Limit: 1 second
Output format:
The first and only line of output contains minimum number of points at which a team may qualify for the play offs .
Sample Input 1:
8
Sample Output 1:
8
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println((n-4)*2);
    }
}
