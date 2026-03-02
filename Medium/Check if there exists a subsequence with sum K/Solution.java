/*Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals the given target sum(k).


Example:

Input:  arr = [10,1,2,7,6,1,5], k = 8.
Output:  Yes
Explanation:  Subsequences like [2, 6], [1, 7] sum upto 8

Input:  arr = [2,3,5,7,9], k = 100. 
Output:  No
Explanation:  No subsequence can sum upto 100
Your Task:
You don't need to read or print anything. Your task is to complete the boolean function checkSubsequenceSum() which takes N, arr and K as input parameter and returns true/false based on the whether any subsequence with sum K could be found.


Expected Time Complexity: O(N * K).
Expected Auxiliary Space: O(N * K).


Constraints:
1 <= arr.length <= 2000.
1 <= arr[i] <= 1000.
1 <= target <= 2000.

 */
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
        int k=sc.nextInt();

        System.out.println(checkSubsequenceSum(n, arr, k));
        sc.close();
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        return solve(arr,K, N, 0,0);
    }
    static boolean solve(int arr[], int k, int n, int index, int sum){
        if(sum==k)return true;
        if(index==n){
            if(sum==k)return true;
            return false;
        }
        if(sum>k)return false;
        if(solve(arr, k, n, index+1, sum+arr[index]))return true;
        
        return solve(arr, k, n, index+1, sum);
    
    }
}