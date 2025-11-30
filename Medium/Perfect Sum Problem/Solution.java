/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.
Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.
Constraints:
1 ≤ arr.size() ≤ 103
0 ≤ arr[i] ≤ 103
0 ≤ target ≤ 103 */
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
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        System.out.println(s.perfectSum(arr, target));
        sc.close();
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n  = nums.length;
        dp = new Integer[n][target+1];
        return solve(nums, target, 0,n,0);
    }
    int solve(int arr[], int target, int index, int n, int sum){
        if(index==n)return (sum==target?1:0);

        if(dp[index][sum]!=null)return dp[index][sum];
        
        int pick = 0;
        if(sum+arr[index]<=target)pick = solve(arr, target, index+1, n, sum+arr[index]);
        int notPick = solve(arr, target, index+1, n, sum);
        
        return dp[index][sum] = pick+notPick;
    }
}