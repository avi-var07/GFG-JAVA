/*You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [5, -2, 3, 4]
Output: 12
Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(maxCircularSum(arr));
        sc.close();
    }
    public static int maxCircularSum(int arr[]) {
        // code here
        int n= arr.length;
        int sum1 =arr[0], sum2=arr[0], minSum = arr[0], total =arr[0], maxSum =arr[0];
        
        for(int i=1;i<n;i++){
            total+=arr[i];
            sum1=Math.max(sum1+arr[i], arr[i]);
            maxSum=Math.max(maxSum, sum1);
            sum2=Math.min(sum2+arr[i], arr[i]);
            minSum=Math.min(minSum, sum2);
        }
        if(maxSum<0)return maxSum;
        return Math.max(maxSum, total-minSum);
    }
}