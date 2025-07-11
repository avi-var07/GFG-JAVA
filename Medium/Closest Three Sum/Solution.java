/*Given an array, arr of integers, and another number target, find three integers in the array such that their sum is closest to the target. Return the sum of the three integers.

Note: If there are multiple solutions, return the maximum one.

Examples :

Input: arr[] = [-7, 9, 8, 3, 1, 1], target = 2
Output: 2
Explanation: There is only one triplet present in the array where elements are -7,8,1 whose sum is 2.
Input: arr[] = [5, 2, 7, 5], target = 13
Output: 14
Explanation: There is one triplet with sum 12 and other with sum 14 in the array. Triplet elements are 5, 2, 5 and 2, 7, 5 respectively. Since abs(13-12) ==abs(13-14) maximum triplet sum will be preferred i.e 14.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
3 ≤ arr.size() ≤ 103
-105 ≤ arr[i] ≤ 105
1 ≤ target ≤ 105 */

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
        
        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        System.out.println("Closest sum among the triplet is: "+threeSumClosest(arr, target));
        sc.close();
    }
    static int threeSumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int closestSum = arr[0]+arr[1]+arr[2];
        for(int i = 0; i<arr.length-2;i++){
            int j = i+1, k=arr.length-1;
            while(j<k){
                
                int sum = arr[i]+arr[j]+arr[k];
                if(sum==target)return target;
                int diff1 = Math.abs(target-sum);
                int diff2 = Math.abs(target-closestSum);
                if(diff1<diff2)closestSum = sum;
                else if(diff1==diff2){
                    if(sum>closestSum)closestSum=sum;
                }
                
                if(sum<target)j++;
                else k--;
            }
            
        }
        
        return closestSum;
    }
}