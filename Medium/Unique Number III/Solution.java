/*Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
Find that element which occurs once.

Examples:

Input: arr[] = [1, 10, 1, 1]
Output: 10
Explanation: 10 occurs once in the array while the other element 1 occurs thrice.
Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
Output: 3
Explanation: All elements except 3 occurs thrice in the array.
Constraints:
1 ≤ arr.size() ≤ 105
arr.size() % 3 = 1
-109 ≤ arr[i] ≤ 109 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        System.out.println("The element that occurs once is: " + getSingle(arr));
        sc.close();
    }
    public static int getSingle(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i]))mp.put(arr[i],mp.get(arr[i])+1);
            else mp.put(arr[i],1);
        }
        
        for(var ele: mp.entrySet())if(ele.getValue()==1)return ele.getKey();
        
        return -1;
    }
}