/*You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.

Examples:

Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: arr[] = [1, 2, 3, 4, 5]
Output: []
Explanation: o candidate occur more than n/3 times.
Constraint:
1 <= arr.size() <= 106
-109 <= arr[i] <= 109 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();

        List<Integer> result = findMajority(arr);
        System.out.println("Candidates with votes greater than one-third of the total votes: " + result);
        sc.close();
    }
    public static List<Integer> findMajority(int[] arr) {
        // Your code goes here.
        ArrayList<Integer> ans = new ArrayList<>();
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i]))mp.put(arr[i],mp.get(arr[i])+1);
            else mp.put(arr[i],1);
        }
        
        for(var ele: mp.entrySet()) if(ele.getValue()>(arr.length/3))ans.add(ele.getKey());
        
        return ans;
    }
}