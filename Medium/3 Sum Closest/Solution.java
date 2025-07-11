/*Given an array arr[] and an integer target, the task is to find the sum of three integers in arr[] such that the sum is closest to target. 

Note: If multiple sums are closest to target, return the maximum one.

Examples:

Input: arr[] = [-1, 2, 2, 4], target = 4
Output: 5
Explanation: All possible triplets
[-1, 2, 2], sum = (-1) + 2 + 2 = 3
[-1, 2, 4], sum = (-1) + 2 + 4 = 5
[-1, 2, 4], sum = (-1) + 2 + 4 = 5
[2, 2, 4], sum = 2 + 2 + 4 = 8
Triplet [-1, 2, 2], [-1, 2, 4] and [-1, 2, 4] have sum closest to target, so return the maximum one, that is 5.
Input: arr[] = [1, 10, 4, 5], target = 10
Output: 10
Explanation: All possible triplets
[1, 10, 4], sum = (1 + 10 + 4) = 15
[1, 10, 5], sum = (1 + 10 + 5) = 16
[1, 4, 5], sum = (1 + 4 + 5) = 10
[10, 4, 5], sum = (10 + 4 + 5) = 19 
Triplet [1, 4, 5] has sum = 10 which is closest to target.
Constraints:
3 <= arr.size() <= 103
-103 ≤ arr[i] ≤ 103
-104 ≤ target ≤ 104


*/
//i is fixed, j and k aare movable pointers.

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
        
        System.out.println("Enter the target to check for: ");
        int target = sc.nextInt();

        System.out.println("Closest Sum to the target among the triplets is: "+closest3Sum(arr, target));
        sc.close();
    }
    static int closest3Sum(int[] arr, int target) {
        // code here
        int closestSum  = arr[0]+arr[1]+arr[2];
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-2;i++){
            int j = i+1, k=arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==target)return target;
                int diff1 = Math.abs(target-sum);
                int diff2 = Math.abs(target - closestSum);
                if(diff1<diff2)closestSum=sum;
                else if(diff1==diff2){
                    if(closestSum<sum)closestSum=sum;
                }
                if(sum<target)j++;
                else k--;
            }
        }
        return closestSum;
    }
}