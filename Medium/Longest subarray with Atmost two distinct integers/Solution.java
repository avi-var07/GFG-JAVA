/*Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

Examples:

Input: arr[] = [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(totalElements(arr));
        sc.close(); 
    }
    public static int totalElements(int[] arr) {
        // code here
        int left = 0, right =0;
        int n = arr.length;
        Map<Integer, Integer>map = new HashMap<>();
        int ans = -1;
        while(right<n){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            if(map.size()>2){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0)map.remove(arr[left]);
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
        
    }

}