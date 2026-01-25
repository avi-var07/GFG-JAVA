/*You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Examples:

Input: 
grid[][] = [['X', 'X', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: We only changed those 'O' that are surrounded by 'X'
Input: 
grid[][] = [['X', 'O', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'O', 'X', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'O', 'O', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: There's no 'O' that's surround by 'X'.
Input: 
grid[][] = [['X', 'X', 'X'], 
          ['X', 'O', 'X'], 
          ['X', 'X', 'X']]
Output: 
[['X', 'X', 'X'], 
['X', 'X', 'X'], 
['X', 'X', 'X']]
Explanation: There's only one 'O' that's surround by 'X'.
Constraints:
1 ≤ grid.size() ≤ 100
1 ≤ grid[0].size() ≤ 100     */


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        char arr[][] = new char[m][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)arr[i][j] = sc.next().charAt(0);
        } 

        fill(arr);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)System.out.print(arr[i][j]+" ");

            System.out.println();
        }
        sc.close();
    }
    public static void fill(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        //first row and last row:    
        for(int i=0;i<n;i++){
            if(!visited[0][i]&&grid[0][i]=='O')dfs(0,i,visited, grid, m,n);
            if(!visited[m-1][i]&&grid[m-1][i]=='O')dfs(m-1,i,visited, grid, m, n);
        }
        
        //first col and last col:
        
        for(int i=0;i<m;i++){
            if(!visited[i][0]&&grid[i][0]=='O')dfs(i, 0, visited, grid, m, n);
            if(!visited[i][n-1]&&grid[i][n-1]=='O')dfs(i, n-1, visited, grid, m, n);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]=='O')grid[i][j]='X';
            }
        }
    }
    static void dfs(int row, int col, boolean visited[][], char grid[][], int m, int n){
        visited[row][col]=true;
        
        int drow[]={-1,1,0,0};
        int dcol[] = {0,0,1,-1};
        
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&!visited[nrow][ncol]&&grid[nrow][ncol]=='O')dfs(nrow, ncol, visited, grid, m,n);
            
        }
    }
}