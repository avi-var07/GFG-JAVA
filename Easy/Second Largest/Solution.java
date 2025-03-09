/*Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist.
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
 */
import java.util.*;
class Solution {
    static int getSecondLargest(int[] arr) {
        // Code Here
        int maxi = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxi)
            maxi=arr[i];
        }
        int second=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>second && arr[i]!=maxi)
            second = arr[i];
        }
        
        return second;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Second Largest Element is: "+getSecondLargest(arr));
        sc.close();
    }
}