/*You are given a number x and array arr[]. Your task is to rearrange the elements of the array according to the absolute difference with x, i.e., an element having minimum difference comes first, and so on.
Note: If two or more elements are at equal distances arrange them in the same sequence as in the given array.

Examples:

Input: x = 7, arr[] = [10, 5, 3, 9, 2]
Output: [5, 9, 10, 3, 2]
Explanation: Sorting the numbers according to the absolute difference with 7, we have array elements as 5, 9, 10, 3, 2.
Input: x = 6, arr[] = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]
Explanation: Sorting the numbers according to the absolute difference with 6, we have array elements as 5, 4, 3, 2, 1.
Constraints:
1 ≤ x ≤ 105
1 ≤ arr.size() ≤ 105
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
        
        System.out.println("Enter the value of x: ");
        int x = sc.nextInt();

        rearrange(arr, x);

        System.out.println("After sorting based on absolute difference: ");
        for(int ele: arr)
        System.out.print(ele+" ");
        sc.close();
    }
    static void rearrange(int[] arr, int x) {
        // code here
        mergeSort(arr, 0, arr.length-1, x);
        
    }
    static void mergeSort(int arr[], int low, int high, int x){
        int mid = low+(high-low)/2;
        if(low<high){
            mergeSort(arr, low, mid, x);
            mergeSort(arr, mid+1, high, x);
            merge(arr, low, mid, high, x);
        }
    }
    static void merge(int arr[], int low, int mid, int high, int x){
        int left =  low;
        int right = mid+1;
        ArrayList<Integer> temp  = new ArrayList<>();
        while(left<=mid&&right<=high){
            int d1 = Math.abs(arr[left]-x);
            int d2 = Math.abs(arr[right]-x);
            if(d1<=d2){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        
        for(int i=low; i<=high;i++)
        arr[i]=temp.get(i-low);
    }
}