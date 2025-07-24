/*Given an array arr[] and an integer target, determine if there exists a triplet in the array whose sum equals the given target.

Return true if such a triplet exists, otherwise, return false.

Examples

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
Output: true 
Explanation: The triplet {1, 4, 8} sums up to 13
Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
Output: true 
Explanation: The triplets {1, 3, 6} and {1, 2, 7} both sum to 10. 
Input: arr[] = [40, 20, 10, 3, 6, 7], target = 24
Output: false 
Explanation: No triplet in the array sums to 24
Constraints:
3 ≤ arr.size() ≤ 103
1 ≤ arr[i] ≤ 105 */
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
        
        System.out.println("Enter target: ");
        int target = sc.nextInt();
        System.out.println(hasTripletSum(arr, target));
        
        sc.close();
    }
    public static boolean hasTripletSum(int arr[], int target) {
        // code Here
        Arrays.sort(arr);
        for(int i = 0; i< arr.length;i++){
            if(i>0&&arr[i]==arr[i-1])continue;
            int j = i+1, k = arr.length-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==target)return true;
                else if(sum<target)j++;
                else k--;
            }
            
        }
        return false;
    }
}