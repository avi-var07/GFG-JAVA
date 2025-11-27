/*Given an array arr[], return the sum of the XOR of all elements for every possible subset of the array. Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

Note: The answer is guaranteed to fit within a 32-bit integer.

Examples:

Input: arr[] = [7, 2]
Output: 14
Explanation: Subsets are: [[], [7], [2], [7, 2]]
Sum of all XOR's = 7 + 2 + (7 ^ 2) = 14.
Input: arr[] = [1, 2, 3]
Output: 12
Explanation: Subsets are: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
Sum of all XOR's = 1 + 2 + 3 + (1 ^ 2)  + (1 ^ 3) + (2 ^ 3) + (1 ^ 2 ^ 3) = 12.
Constraints:
1 ≤ arr.size() ≤ 30
1 ≤ arr[i] ≤ 103

 */

import java.util.*;

class Solution{
    Integer dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        Solution s = new Solution();
        System.out.println(s.subsetXORSum(arr));
        
        sc.close();
    }

    int subsetXORSum(int arr[]) {
        // code here
        int n =arr.length;
        dp = new Integer[n][1024];
        return solve(arr, 0,n, 0);
    }
    int solve(int arr[], int xor, int n, int index){
        if(index==n)return xor;
        
        if(dp[index][xor]!=null)return dp[index][xor];
        
        int pick = solve(arr, xor^arr[index], n, index+1);
        int notPick = solve(arr, xor, n, index+1);
        
        return dp[index][xor] = pick+notPick;
        
    }
}