/*Given a sorted array arr with possibly some duplicates, the task is to find the first and last occurrences of an element x in the given array.
Note: If the number x is not found in the array then return both the indices as -1.

Examples:

Input: arr[] = [1, 3, 5, 5, 5, 5, 67, 123, 125], x = 5
Output: [2, 5]
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5
Input: arr[] = [1, 3, 5, 5, 5, 5, 7, 123, 125], x = 7
Output: [6, 6]
Explanation: First and last occurrence of 7 is at index 6
Input: arr[] = [1, 2, 3], x = 4
Output: [-1, -1]
Explanation: No occurrence of 4 in the array, so, output is [-1, -1]
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], x ≤ 109 */

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
        int x = sc.nextInt();

        ArrayList<Integer> ans = find(arr, x);

        for(int ele: ans)
        System.out.print(ele+" ");
        sc.close();
    }
    static ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(binarySearch(arr, x, true));
        ans.add(binarySearch(arr, x,false));
        
        return ans;
        
    }
    static int binarySearch(int arr[], int x, boolean firstOccurence){
        int low = 0, high = arr.length-1, index=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==x){
                index=mid;
                if(firstOccurence)high=mid-1;
                else low=mid+1;
            }
            else if(arr[mid]<x)low=mid+1;
            else high=mid-1;
        }
        return index;
    }
}