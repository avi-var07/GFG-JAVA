/*Given an array arr[] containing both positive and negative integers, the task is to find the length of the longest subarray with a sum equals to 0.

Note: A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
Constraints:
1 ≤ arr.size() ≤ 106
−103 ≤ arr[i] ≤ 103 */

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
        
        System.out.println("Longest subarray with 0 sum is: "+maxLength(arr));
        
        sc.close();
    }
    static int maxLength(int arr[]) {
        // code here
        int prefixSum = 0, maxLen=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            prefixSum+= arr[i];
            if(prefixSum==0)maxLen = i+1;
            
            if(map.containsKey(prefixSum)){
                int len = i-map.get(prefixSum);
                if(len>maxLen)maxLen = len;
            }
            else map.put(prefixSum, i);
        }
        return maxLen;
    }
}