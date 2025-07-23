/*Given an unsorted array arr[] of integers and a sum k. The task is to count the number of subarrays that add to a given number k.

Examples:

Input: arr[] = [10, 2, -2, -20, 10], k = -10
Output: 3
Explanation: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
Input: arr[] = [1, 4, 20, 3, 10, 5], k = 33
Output: 1
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ arr.size() ≤ 106
-106 ≤ arr[i],k ≤ 106 */

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
        
        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Number of subarrys with given target as sum are: "+subArraySum(arr, target));
        
        sc.close();
    }
    public static int subArraySum(int[] arr, int k) {
        // code here.
        int prefixSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            prefixSum  += arr[i];
            if(prefixSum==k)count++;
            
            int remaining = prefixSum - k;
            if(map.containsKey(remaining))count+=map.get(remaining);
            
            map.put(prefixSum , map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}