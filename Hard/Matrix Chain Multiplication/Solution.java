/*Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

Examples:

Input: arr[] = [2, 1, 3, 4]
Output: 20
Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let this 3 input matrices be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)), note that the result of (M1 x M2) is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix. 
((M1 x M2) x M3)  requires (2 x 1 x 3) + (2 x 3 x 4) = 30 
(M1 x (M2 x M3))  requires (1 x 3 x 4) + (2 x 1 x 4) = 20. 
The minimum of these two is 20.
Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Explanation: There are 4 matrices of dimensions 1 × 2, 2 × 3, 3 × 4, 4 × 3. Let this 4 input matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1 x M2) x M3) x M4). The minimum number is (1 x 2 x 3) + (1 x 3 x 4) + (1 x 4 x 3) = 30.
Input: arr[] = [3, 4]
Output: 0
Explanation: As there is only one matrix so, there is no cost of multiplication.
Constraints: 
2 ≤ arr.size() ≤ 100
1 ≤ arr[i] ≤ 200 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(matrixMultiplication(arr));
        sc.close();
    }
    static int dp[][];
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        dp=new int [n-1][n-1];
        return dfs_tab(arr, n);
        
    }
    // static int dfs(int i, int j, int arr[]){
    //     if(i==j)return dp[i][j]=0;
        
    //     if(dp[i][j]!=null)return dp[i][j];
    //     int mini = Integer.MAX_VALUE;
    //     for(int k=i;k<j;k++){
    //         int l= dfs(i, k, arr);
    //         int r=dfs(k+1, j, arr);
            
    //         int m = arr[i]*arr[k+1]*arr[j+1];
            
    //         int total = l+r+m;
    //         mini=Math.min(mini, total);
    //     }
    //     return dp[i][j]=mini;
    // }
    
    static int dfs_tab(int arr[], int n){
        
        for(int diagonal =0; diagonal<n;diagonal++){
            for(int i=0, j=diagonal;j<n-1;i++, j++){
                
                if(i==j){
                    dp[i][j]=0;
                    continue;
                }
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int l = dp[i][k];
                    int r =dp[k+1][j];
                    
                    int m = arr[i]*arr[k+1]*arr[j+1];
                    int total = l+r+m;
                    mini = Math.min(mini, total);
                    
                }
                dp[i][j]=mini;
            }
        }
        return dp[0][n-2];
    }
}