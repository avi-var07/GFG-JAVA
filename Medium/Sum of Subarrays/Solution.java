/*Given an array arr. Find the sum of all subarrays of the array since the sum could be very large print the sum modulo (109+7).

Examples:

Input: arr[] = [1, 2, 3]
Output: 20
Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1,2] = 3, [2,3] = 5, [1,2,3] = 6. Thus total sum is 1+2+3+3+5+6 = 20.
Input: arr[] = [1, 3]
Output: 8
Explanation: All subarray sums are: [1] = 1 [3] = 3 [1,3] = 4. Thus total sum is 1+3+4 = 8.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints :
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 109

 */
//solution mei mathematical formula hai basically, otherwise brute force hai: 

/*

long total =0;
fo(int i=0;i<n;i++){
int sum=0;
for(int j=i;j<n;j++){
sum+=arr[i];
total+=sum;
}
return total;
}
  */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("All subarrays sum is: "+subarraySum(arr));
        sc.close();
    }

    public static long subarraySum(int[] arr) {
        long mod = 1_000_000_007;
        long total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            long startOptions = i + 1;
            long endOptions = n - i;
            long contribution = ((startOptions * endOptions) % mod * arr[i]) % mod;
            total = (total + contribution) % mod;
        }

        return total;
    }

}