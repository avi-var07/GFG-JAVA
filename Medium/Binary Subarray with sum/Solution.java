/*Given a binary array arr[] and an integer target, return the number of non-empty subarrays with a sum equal to the target.
Note: A subarray is the contiguous part of the array.

Examples:

Input: arr[] = [1, 0, 1, 0, 1], target = 2
Output: 4
Explanation: There are four subarrays with sum equal to target: arr[0..2], arr[0..3], arr[1..4], arr[2..4].
Input: arr[] = [1, 1, 0, 1, 1], target = 5
Output: 0
Explanation: There are no subarrays with sum target.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

 */
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
        System.out.println("Number of binary subarrays that sum up to the target is: "+numberOfSubarrays(arr, target));
        sc.close();
    }
    public static int numberOfSubarrays(int[] arr, int target) {
        // code here
        int count = 0, prefixSum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==target)count++;
            int remaining = prefixSum - target;
            
            if(map.containsKey(remaining))
            count+=map.get(remaining);
            
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}