package Group4.set2;

public class MatrixGym {
    /*
    Ninja has put on some extra weight during lockdown. He has decided to join a gym to shed this extra weight off. He joined the Matrix Gym, where the trainer has planned an elaborate exercise for him. It is upto Ninja to decide how many calories he wants to burn during his workout, whereas the trainer designs the exercise. The basic idea of each day remains the same. Ninja has to perform his exercise by crossing his Matrix Gym, which is a 2-D Grid consisting of hurdle cells (represented by “ # ”) and clear cells (represented by “ . “ ). He has to avoid the hurdles, and by entering each clear cell he burns 5 calories. He begins from the top-left corner of the grid. It is given that starting position has no hurdle. He has to reach the bottom-right cell which is also hurdle free. You have to find out if a path exists through which Ninja can burn his decided amount of calories. Ninja can take only one step at a time. Also, when Ninja is standing at (i, j), he can move to (i, j+1) and (i+1, j) only (right and bottom cells). If such a path is possible, print “Yes”, otherwise print “No”. If more than one path is present in the gym through which the calories can be burnt, find the path which burns the maximum calories, and print the extra amount of calories burnt by Ninja.
Input Format:
The first line of input contains an integer N which denotes the number of rows in the grid.
The following line of input contains N space separated strings deciding the structure of hurdle and clear cells in the grid
The third line contains the number of calories to be burnt.
Constraints:
1 <= N <= 10^5
1 <= calories <= 10^5
Output Format:
For each query, you have to print “Yes” along with additional calories burnt (if any) if the path is found, otherwise you have to print “No”.
Sample Input 1:
3
..## #.## #...
15
Sample Output 1:
Yes 10
Explanation:
For the given input the grid formed is [ ‘..##’ , ‘#.##’ , ‘#...’ ]
For this grid, Ninja can easily travel from cell (0,0) which is his starting point, till cell (2,3) which is his end point, and burn 25 calories in the process.
He had decided to burn 15 calories. Hence additional calories burnt are 25-15 = 10
Sample Input 2:
4
...## .#..# .##.# ..#..
30
Sample Output 2:
Yes 5
Explanation:
For the given input the grid formed is [ ‘...##’ , ‘.#..#’ , ‘.##.#’ , ‘..#..’ ].
For this grid, Ninja can easily travel from cell (0,0) which is his starting point, till cell (3,4) which is his end point, and burn 25 calories in the process.
He had decided to burn 15 calories. Hence additional calories burnt are 35-30 = 5
Sample Input 3:
4
...## .#..# .##.# ..#..
35
Sample Output 3:
Yes
Explanation:
For the given input the grid formed is [ ‘...##’ , ‘.#..#’ , ‘.##.#’ , ‘..#..’ ]
For this grid, Ninja can easily travel from cell (0,0) which is his starting point, till cell (3,4) which is his end point, and burn 25 calories in the process.
He had decided to burn 15 calories. Hence additional calories burnt are 35-35 = 0
     */

}
