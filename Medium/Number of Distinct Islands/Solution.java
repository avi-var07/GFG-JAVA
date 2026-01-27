/*Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = [[1, 1, 0, 0, 0],
            [1, 1, 0, 0, 0],
            [0, 0, 0, 1, 1],
            [0, 0, 0, 1, 1]]
Output: 1
Explanation:
grid[][] = [[1, 1, 0, 0, 0], 
            [1, 1, 0, 0, 0], 
            [0, 0, 0, 1, 1], 
            [0, 0, 0, 1, 1]]
Same colored islands are equal. We have 2 equal islands, so we have only 1 distinct island.

Example 2:

Input:
grid[][] = [[1, 1, 0, 1, 1],
            [1, 0, 0, 0, 0],
            [0, 0, 0, 0, 1],
            [1, 1, 0, 1, 1]]
Output: 3
Explanation:
grid[][] = [[1, 1, 0, 1, 1], 
            [1, 0, 0, 0, 0], 
            [0, 0, 0, 0, 1], 
            [1, 1, 0, 1, 1]]
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task: You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        int arr[][] = new int[m][n];

        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }

        System.out.println(countDistinctIslands(arr));

        sc.close();
    }
    static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        Set<List<Integer>>set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    List<Integer>shape = new ArrayList<>();
                    dfs(i, j, i, j, visited, grid, m, n, shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    static void dfs(int row, int col, int baseRow, int baseCol, boolean visited[][], int grid[][], int m, int n, List<Integer>shape){
        visited[row][col] = true;
        
        shape.add(row-baseRow);
        shape.add(col-baseCol);
        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,1,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col +dcol[i];
            
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&!visited[nrow][ncol]&&grid[nrow][ncol]==1)dfs(nrow, ncol, baseRow, baseCol, visited, grid, m, n, shape);
            
            
        }
        
    }
}