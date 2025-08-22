/*You are given a 2D matrix mat[][] of size n x m that was initially filled in the following manner:


Each row is sorted in increasing order from left to right.
The first element of every row is greater than the last element of the previous row.

This implies that if the matrix is flattened row-wise, it forms a strictly sorted 1D array.
Later, this sorted 1D array was rotated at some unknown pivot. The rotated array was then written back into the matrix row-wise to form the current matrix.


Given such a matrix mat[][] and an integer x, determine whether x exists in the matrix.


Examples:

Input: x = 3,
mat[][] = [[7, 8, 9, 10],           
          [11, 12, 13, 1],
          [2, 3, 4, 5]] 
Output: true
Explanation: 3 is located at the 3rd row and 2nd column.
Input: x = 10,
mat[][] = [[6, 7, 8],                         
          [9, 1, 2],
          [3, 4, 5]]
Output: false
Explanation: The value 10 does not exist in the matrix.
Constraint:
1 ≤ n × m ≤ 105
1 ≤ mat[i][j], x ≤ 106 */

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

        System.out.println("Enter the target to search for: ");
        int target = sc.nextInt();


        System.out.println(searchMatrix(arr, target));
        
        sc.close();
    }

    public static boolean searchMatrix(int[][] mat, int x) {
        // code here
        for(int i =0;i<mat.length;i++){
            if(binarySearch(mat[i], x))return true;
        }
        return false;
        
    }
    static boolean binarySearch(int arr[], int target){
        int low = 0, high  = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target)return true;
            else if(arr[low]<=arr[mid]){
                if(arr[mid]>=target&&arr[low]<=target)high=mid-1;
                else low= mid+1;
            }
            else{
                if(arr[mid]<=target&&arr[high]>=target)low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}