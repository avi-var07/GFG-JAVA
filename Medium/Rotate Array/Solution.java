/*Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

Note: Consider the array as circular.

Examples :

Input: arr[] = [1, 2, 3, 4, 5], d = 2
Output: [3, 4, 5, 1, 2]
Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
Input: arr[] = [7, 3, 9, 1], d = 9
Output: [3, 9, 1, 7]
Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.
Constraints:
1 <= arr.size(), d <= 105
0 <= arr[i] <= 105

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
         
         System.out.println("Enter number of times to left rotate: ");
         int d = sc.nextInt();

         System.out.println("Before rotation: ");
         for(int ele: arr)
         System.out.print(ele+" ");

         System.out.println();
         
         rotateArr(arr, d);

         System.out.println("After left rotation: ");
         
         for(int ele: arr)
         System.out.print(ele+" ");

         
         sc.close();
     }
     static void reverse(int arr[], int start, int end){
        if(start>=end)return;
        int temp = arr[start];
        arr[start]=arr[end];
        arr[end] = temp;
        reverse(arr,start+1, end-1);
    }
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n = arr.length;
        d%=n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
 }