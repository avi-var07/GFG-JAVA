/*You are given an array arr[] of positive integers and an integer k. You have to count the number of subarrays that contain exactly k odd numbers.

Examples:

Input: arr[] = [2, 5, 6, 9], k = 2
Output: 2
Explanation: There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].
Input: arr[] = [2, 2, 5, 6, 9, 2, 11], k = 2
Output: 8
Explanation: There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11].
Constraint:
1 ≤ k ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println(countSubarrays(arr, k));
        sc.close();
    }
    public static int countSubarrays(int[] arr, int k) {
        // code here
        return atMostk(arr,k)-atMostk(arr, k-1);
        
    }
    static int atMostk(int arr[], int k){
        int n = arr.length;
        int left = 0, right =0;
        int count = 0, ans=0;
        while(right<n){
            if(arr[right]%2==1)count++;
            while(count>k){
                if(arr[left]%2==1)count--;
                left++;
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
}