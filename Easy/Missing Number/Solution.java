/*You are given an array arr of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.

Examples:

Input: arr[] = [1, 2, 3, 5]
Output: 4
Explanation: All the numbers from 1 to 5 are present except 4.
Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.
Input: arr[] = [1]
Output: 2
Explanation: Only 1 is present so the missing element is 2.
 */

 import java.util.*;

 class Solution {
     static int missingNumber(int arr[]) {
         // code here
         Arrays.sort(arr);
         
         int ans = 0;
         
         for(int i=0;i<arr.length;i++){
             if(arr[i]!=i+1){
                 ans=i+1;
                 break;
             }
         }
         
         if(ans==0)
         ans=arr.length+1;
         
         return ans;
     }
     public static void main(String[] args) {
         System.out.println("Enter the size of the array");
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int arr[] = new int[n];
         System.out.println("Enter the elements of the array");
         for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
         System.out.println("Missing Number is : "+missingNumber(arr));
 
         sc.close();
     }
 }