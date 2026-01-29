/*Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.

Examples:
Input: mat[][] = [[16, 28, 60, 64], k = 3
                [22, 41, 63, 91],
                [27, 50, 87, 93],
                [36, 78, 87, 94]]
Output: 27
Explanation: 27 is the 3rd smallest element.
Input: mat[][] = [[10, 20, 30, 40], k = 7
                [15, 25, 35, 45],
                [24, 29, 37, 48],
                [32, 33, 39, 50]] 
Output: 30
Explanation: 30 is the 7th smallest element.
Constraints:
1 ≤ n ≤ 500
1 ≤ mat[i][j] ≤ 104
1 ≤ k ≤ n*n

 */


import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of matrix: ");
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        System.out.println("Enter "+n*n+" elements: ");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)arr[i][j] = sc.nextInt();
        }
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println(kthSmallest(arr, k));
        sc.close();
    }
    public static int kthSmallest(int[][] mat, int k) {
        // code here
        int  n = mat.length;
        int low = mat[0][0], high = mat[n-1][n-1];
        
        while(low<high){
            int mid = low+(high-low)/2;
            
            if(counter(mat,n,mid)<k)low=mid+1;
            else high=mid;
        }
        return low;
    }
    static int counter(int arr[][], int n, int mid){
        int row =0, col = n-1;
        int count=0;
        while(row<n&&col>=0){
            if(arr[row][col]<=mid){
                count+=col+1;
                row++;
            }
            else col--;
        }
        return count;
    }
}