/*Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.
Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
Constraints:

1 ≤ arr.size() ≤ 105
-103 ≤ arr[i] ≤ 103
-107 ≤ k ≤ 107 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int arr[]= new int[n];

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Enter the target to check for subarray sum: ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays with sum equals K is: "+countSubarrays(arr, k));
        sc.close();
    }
    public static int countSubarrays(int arr[], int k) {
        // code here
        int prefixSum=0, count=0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];
            
            if(prefixSum==k)count++;
            
            int remaining = prefixSum-k;
            
            if(mp.containsKey(remaining))count+=mp.get(remaining);
            
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}