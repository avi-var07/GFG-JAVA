/*You are given a 2D grid image[][], where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate (sr, sc) representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.

Examples:

Input: image[][] = [[1, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]], sr = 1, sc = 2, newColor = 2

Output: [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]]

Explanation: Starting from pixel (1, 2) with value 1, flood fill updates all connected pixels (up, down, left, right) with value 1 to 2, resulting in [[2, 2, 2, 0], [0, 2, 2, 2], [1, 0, 2, 2]].
Input: image[][] = [[0, 1, 0], [0, 1, 0]], sr = 0, sc = 1, newColor = 0
Output: [[0, 0, 0], [0, 0, 0]]
Explanation: Starting from pixel (0, 1) with value 1, flood fill changes all 4-directionally connected pixels with value 1 to 0, resulting in [[0, 0, 0], [0, 0, 0]]
Constraints:
1 ≤ n ≤ m ≤ 500
0 ≤ image[i][j] ≤ 10
0 ≤ newColor ≤ 10
0 ≤ sr ≤ (n-1)
0 ≤ sc ≤ (m-1)  
 
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        System.out.println("Enter "+n*m+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Enter starting row: ");
        int srow = sc.nextInt();
        System.out.println("Enter starting column: ");
        int scol = sc.nextInt();
        System.out.println("Enter new color you want: ");
        int color = sc.nextInt();

        int ans[][] = floodFill(arr, srow, scol, color);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)System.out.print(ans[i][j]+" ");
            System.out.println();
        }
        sc.close();
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int prev = image[sr][sc];
        if(prev==newColor)return image;
        dfs(image, sr, sc, prev, newColor,image.length, image[0].length);
        return image;
    }
    static void dfs(int[][] image, int sr, int sc, int prev, int newColor, int n, int m){
        if(sr<0||sr>=n||sc<0||sc>=m||image[sr][sc]!=prev)return;
        image[sr][sc] = newColor;
        
        dfs(image, sr+1, sc, prev, newColor, n, m);
        dfs(image, sr-1, sc, prev, newColor, n, m);
        dfs(image, sr, sc+1, prev, newColor, n, m);
        dfs(image, sr, sc-1, prev, newColor, n, m);
    }
}
