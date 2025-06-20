/*Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109 */

//Approach is PrefixSum + HashMap

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Enter the target(k): ");
        int k = sc.nextInt();
        
        System.out.println("Longest Subarray with sum k is: "+ longestSubarray(arr, k));
        sc.close();
    }

    public static int longestSubarray(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0, maxLen = 0;

        for(int i = 0;i<arr.length;i++){
            prefixSum+=arr[i];

            if(prefixSum==k)maxLen = i+1;

            int remaining = prefixSum - k;

            if(map.containsKey(remaining)){
                int len = i - map.get(remaining);
                if(len>maxLen)maxLen=len;
            }

            if(!map.containsKey(prefixSum))map.put(prefixSum,i);
        }

        return maxLen;
    }
}