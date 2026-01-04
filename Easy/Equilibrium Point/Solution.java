/*Given an array of integers arr[], the task is to find the first equilibrium point in the array.

The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2 
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.
Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.
Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.
Constraints:
3 <= arr.size() <= 105
-104 <= arr[i] <= 104 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(findEquilibrium(arr));
        sc.close();
    }
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int ps[] = new int[n];
        ps[0]=arr[0];
        for(int i=1;i<n;i++)ps[i]=ps[i-1]+arr[i];
        
        int total = ps[n-1];
        for(int i=1;i<n-1;i++){
            int leftSum = ps[i-1];
            int rightSum = total-ps[i];
            if(leftSum==rightSum)return i;
        }
        return -1;
    }
}