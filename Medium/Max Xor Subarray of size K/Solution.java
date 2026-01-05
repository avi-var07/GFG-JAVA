/*Given an array of integers arr[]  and a number k. Return the maximum xor of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [2, 5, 8, 1, 1, 3], k = 3
Output: 15
Explanation: arr[0] ^ arr[1] ^ arr[2] = 15, which is maximum.
Input: arr[] = [1, 2, 4, 5, 6] , k = 2
Output: 6
Explanation: arr[1] ^ arr[2] = 6, which is maximum.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size() */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maxSubarrayXOR(arr, n));
        sc.close();
    }
    public static int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int xor = 0;
        for(int i=0;i<k;i++)xor^=arr[i];
        int maxi = xor;
        for(int i=k;i<n;i++){
            xor^=arr[i];
            xor^=arr[i-k];
            if(xor>maxi)maxi=xor;
        }
        return maxi;
    }
}