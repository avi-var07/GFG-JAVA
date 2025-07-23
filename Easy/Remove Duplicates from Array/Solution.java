/*Given an array arr[] consisting of positive integers, return the array by removing all duplicate numbers.

Example:

Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
Input: arr[] = [1, 2, 3, 4, 5] 
Output: [1, 2, 3, 4, 5]
Explanation: There doesn't exists any duplicate element.
Constraints:
1 ≤ arr.size() ≤ 106
2 ≤ arr[i] ≤ 109 */
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
        
        ArrayList<Integer> ans = remDuplicate(arr);

        System.out.println("Array after removing duplicates: ");
        for(int ele: ans)
        System.out.print(ele+" ");
        sc.close();
    }
    static ArrayList<Integer> remDuplicate(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: arr)map.put(num, map.getOrDefault(num,0)+1);
        
        for(var ele: map.keySet())
        ans.add(ele);
        
        return ans;
    }
}