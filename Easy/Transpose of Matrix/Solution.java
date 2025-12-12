/*You are given a square matrix of size n x n. Your task is to find the transpose of the given matrix.
The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.

Examples :

Input: mat[][] = [[1, 1, 1, 1],
                [2, 2, 2, 2],
                [3, 3, 3, 3],
                [4, 4, 4, 4]]
Output: [[1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4]]
Explanation: Converting rows into columns and columns into rows.
Input: mat[][] =  [[1, 2],
                 [9, -2]]
Output: [[1, 9],
        [2, -2]]
Explanation: Converting rows into columns and columns into rows.
Constraints:
1 ≤ n ≤ 103
-109 ≤ mat[i][j] ≤109

 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>>ans = transpose(arr);
        for(var ele: ans)System.out.print(ele+" ");


        sc.close();
    }
    public static ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        for(int i=0;i<n;i++){
            ArrayList<Integer>row = new ArrayList<>();
            for(int j = 0;j<n;j++)row.add(mat[j][i]);
            
            ans.add(row);
        }
        return ans;
    }
}