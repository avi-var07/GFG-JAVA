/*Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], 
                ['W', 'L', 'W', 'W', 'L'], 
                ['L', 'W', 'W', 'L', 'L'], 
                ['W', 'W', 'W', 'W', 'W'], 
                ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.
 
Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'} */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m= sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n= sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+m*n+" elements: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        }

        System.out.println(countIslands(arr));
        sc.close();
    }
    public static int countIslands(char[][] grid) {
        // Code here
        int ans =0;
        int m =grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]=='L'){
                    ans++;
                    dfs(i,j,visited,grid, m, n);
                }
            }
        }
        return ans;
    }
    static void dfs(int row, int col, boolean visited[][], char grid[][], int m, int n){
        
        if(row<0||col<0||row>=m||col>=n||visited[row][col]||grid[row][col]=='W')return;
        visited[row][col]=true;
        
        dfs(row-1,col,visited,grid,m,n); //up (North)
        dfs(row-1, col+1, visited, grid, m,n); //North-East
        dfs(row,col+1,visited, grid, m, n); //East
        dfs(row+1, col+1, visited, grid, m, n); //South-East
        dfs(row+1, col, visited, grid, m,n); //South
        dfs(row+1, col-1, visited, grid, m, n); //South-West
        dfs(row, col-1, visited, grid, m, n); //West
        dfs(row-1, col-1, visited, grid, m, n); //North-West 
        
        
    }
}