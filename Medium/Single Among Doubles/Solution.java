/*Given a sorted array arr[] of n positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Examples :

Input: n = 5, arr[] = {1, 1, 2, 5, 5}
Output: 2
Explanation: Since 2 occurs once, while other numbers occur twice, 2 is the answer.
Input: n = 7, arr[] = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.
Expected Time Complexity: O( Log(n) ).
Expected Auxiliary Space: O(1).

Constraints
0 <  n  <= 10^6
0 <= arr[i] <= 10^9

 */
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
        
        System.out.println("Single element is: "+search(n, arr));
        sc.close();
    }
    public static int search(int n, int arr[]) {
        // your code here
        if(arr.length==1)return arr[0];
        if(arr[0]!=arr[1])return arr[0];
        
        if(arr[arr.length-1]!=arr[arr.length-2])return arr[arr.length-1];
        
        
        int low = 1, high = arr.length-2;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(arr[mid]!=arr[mid-1]&&arr[mid]!=arr[mid+1])return arr[mid];
            else if((mid%2==1&&arr[mid]==arr[mid-1])||(mid%2==0&&arr[mid]==arr[mid+1]))low=mid+1;
            else high = mid-1;
        }
        
        return -1;
    }
}