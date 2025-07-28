/*You are given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist).

If there are multiple peak elements, Return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".

Note: Consider the element before the first element and the element after the last element to be negative infinity.

Examples :

Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
Input: arr = [10, 20, 15, 2, 23, 90, 80]
Output: true
Explanation: Element 20 at index 1 is a peak since 10 < 20 > 15. Index 5 (value 90) is also a peak, but returning any one peak index is valid.
Constraints:
1 ≤ arr.size() ≤ 106
-231 ≤ arr[i] ≤ 231 - 1 */

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
        
        System.out.println("Peak element index is: "+peakElement(arr));
        sc.close();
    }
    public static int peakElement(int[] arr) {
        // code here
        if(arr.length==1)return 0;
        
        if(arr[0]>arr[1])return 0;
        
        if(arr[arr.length-1]>arr[arr.length-2])return arr.length-1;
        
        int low=1, high = arr.length-2;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1])return mid;
            else if(arr[mid]>arr[mid-1])low=mid+1;
            else high = mid-1;
        }
        return -1;
    }
}