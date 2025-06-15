/*Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements (0, 1 or 2): ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i]!=0 && arr[i]!=1 && arr[i]!=2){
                System.out.println("You Should enter only 0, 1 or 2!!!");
                System.exit(0);
            }
        }

        sort012(arr);

        for(int num: arr)
        System.out.print(num+" ");

        sc.close();
    }
    public static void sort012(int[] arr) {
        // code here
           int low = 0, mid = 0, high  = arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1)mid++;

            else {
                swap(arr, high, mid);
                high--;
            }
        }

    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}