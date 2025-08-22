/*Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.

Examples:

Input: mat[][] = [[1, 3, 5], 
                [2, 6, 9], 
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
Input: mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.
Input: mat = [[3], [4], [8]]
Output: 4
Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.
Constraints:
1 ≤ n, m ≤ 400
1 ≤ mat[i][j] ≤ 2000

 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter " + n*m + " elements:");
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++)
            arr[i][j] = sc.nextInt();
        }
        System.out.println("Median is: "+median(arr));
        sc.close();
    }
    public static int median(int[][] mat) {
        // code here
        int low = mat[0][0];
        int high = mat[mat.length-1][mat[0].length-1];
        
        for(int i = 0;i<mat.length;i++){
            if(low>mat[i][0])low=mat[i][0];
            if(high<mat[i][mat[0].length-1])high = mat[i][mat[0].length-1];
        
        }
        int req = (mat.length*mat[0].length)/2;
        while(low<=high){
            int mid = low+(high-low)/2;
            int smaller = count(mat, mid);
            if(smaller<=req)low=mid+1;
            else high = mid-1;
        }
        return low;
    }
    
    static int count(int arr[][], int x){
        int ans = 0;
        for(int i=0;i<arr.length;i++)ans+=upperBound(arr[i], x);
        return ans;
    }
    
    static int upperBound(int arr[], int ele){
        int low = 0, high = arr.length-1, ans = arr.length;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]>ele){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}