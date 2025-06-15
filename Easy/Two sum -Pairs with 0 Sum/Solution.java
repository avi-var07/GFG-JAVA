/*Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.

Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.

Examples:

Input: arr = [-1, 0, 1, 2, -1, -4]
Output: [[-1, 1]]
Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
arr[2] + arr[4] = 1 + (-1) = 0.
The distinct pair are [-1,1].
Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
Output: [[-6, 6],[-1, 1]]
Explanation: The distinct pairs are [-1, 1] and [-6, 6].
Expected Time Complexity: O(n log n)
Expected Auxiliary Space: O(n).

Constraints:
3 <= arr.size <= 105
-105 <= arr[i] <= 105 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i =0;i<n;i++)
        arr[i]=sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = getPairs(arr);

        System.out.println("Distinct Pairs whose sum ==0  are:  ");

        for(ArrayList<Integer> ele: ans)
        System.out.print(ele+" ");

        sc.close();
    }
       public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
    
        while (left < right) {
            int sum = arr[left] + arr[right];
    
            if (sum == 0) {
                int a = arr[left], b = arr[right];
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(a);
                pair.add(b);
                result.add(pair);
    
                // Skip duplicates
                while (left < right && arr[left] == a) left++;
                while (left < right && arr[right] == b) right--;
            } 
            else if (sum < 0) left++;
            
            else right--;
            
        }
    
        return result;
    }
}