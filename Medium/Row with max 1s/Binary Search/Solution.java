/*You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

Note:

The array follows 0-based indexing.
The number of rows and columns in the array are denoted by n and m respectively.
Examples:

Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output is 1.
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
Constraints:
1 ≤ arr.size(), arr[i].size() ≤ 103
0 ≤ arr[i][j] ≤ 1 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m = sc.nextInt();
        System.out.println("Enter " + n*m + " binary elements:");
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j=0;j<m;j++)arr[i][j] = sc.nextInt();
        }

        System.out.println("Row with maximum 1s is: "+rowWithMax1s(arr));
        
        sc.close();
    }
    public static int rowWithMax1s(int arr[][]) {
        // code here
        int countMax = 0, index = -1;
        for(int i=0;i<arr.length;i++){
            int countOnes = arr[i].length-lowerBound(arr[i],1 );
            if(countOnes>countMax){
                countMax=countOnes;
                index=i;
            }
        }
        return index;
    }
    static int lowerBound(int arr[], int x){
        int low = 0, high = arr.length-1, ans=arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                ans = mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}