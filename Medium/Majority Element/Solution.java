/*Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.

Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

Examples:

Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
Output: 1
Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.
Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than 2/2 times, so there is no majority element.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105

 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        System.out.println("The majority element is: " + majorityElement(arr));
        sc.close();
    }
    static int majorityElement(int arr[]) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i]))mp.put(arr[i],mp.get(arr[i])+1);
            else mp.put(arr[i],1);
        }
        
        for(var ele: mp.entrySet())if(ele.getValue()>(arr.length/2))return ele.getKey();
        
        return -1;
    }
}