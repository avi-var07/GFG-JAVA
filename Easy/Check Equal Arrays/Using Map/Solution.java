/*Given two arrays a[] and b[] of equal size, the task is to find whether the elements in the arrays are equal.
Two arrays are said to be equal if both contain the same set of elements, arrangements (or permutations) of elements may be different though.
Note: If there are repetitions, then counts of repeated elements must also be the same for two arrays to be equal.

Examples:

Input: a[] = [1, 2, 5, 4, 0], b[] = [2, 4, 5, 0, 1]
Output: true
Explanation: Both the array can be rearranged to [0,1,2,4,5]
Input: a[] = [1, 2, 5], b[] = [2, 4, 15]
Output: false
Explanation: a[] and b[] have only one common value.
Constraints:
1 ≤ a.size(), b.size() ≤ 107
0 ≤ a[i], b[i] ≤ 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements of first array:");
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter " + n + " elements of second array:");
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr2[i] = sc.nextInt();
        
        System.out.println(checkEqual(arr1, arr2));
        sc.close();
    }
    public static boolean checkEqual(int[] a, int[] b) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele: a)
        map.put(ele, map.getOrDefault(ele, 0)+1);

        for(int ele: b){
            if(!map.containsKey(ele))return false;
            map.put(ele, map.get(ele)-1);
            if(map.get(ele)<0)return false;
        }
        return true;
    }
}