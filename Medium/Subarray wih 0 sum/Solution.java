/*Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum. Return true/false depending upon whether there is a subarray present with 0-sum or not. 

Examples:

Input: arr[] = [4, 2, -3, 1, 6]
Output: true
Explanation: 2, -3, 1 is the subarray with a sum of 0.
Input: arr = [4, 2, 0, 1, 6]
Output: true
Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
Input: arr = [1, 2, -1]
Output: false
Constraints:
1 <= arr.size <= 104
-105 <= arr[i] <= 105 */

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
        
        if(findsum(arr))System.out.println("True");
        else System.out.println("False");
        sc.close();
    }
    static boolean findsum(int arr[]) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for(int i = 0; i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==0)return true;
            
            if(map.containsKey(prefixSum))return true;
            else map.put(prefixSum,i);
        }
        return false;
    }
}