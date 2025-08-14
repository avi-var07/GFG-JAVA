/*You are given an array arr[] of positive integers, find the count of reverse pairs. A pair of indices (i, j) is said to be a reverse pair if both the following conditions are met:

0 ≤ i < j < arr.size()
arr[i] > 2 * arr[j]
Examples:
Input: arr[] = [3, 2, 4, 5, 1, 20]
Output: 3
Explanation:
The Reverse pairs are 
(0, 4), arr[0] = 3, arr[4] = 1, 3 > 2*1 
(2, 4), arr[2] = 4, arr[4] = 1, 4 > 2*1 
(3, 4), arr[3] = 5, arr[4] = 1, 5 > 2*1 
Input: arr[] = [5, 4, 3, 2, 2]
Output: 2
Explanation:
The Reverse pairs are
(0, 3), arr[0] = 5, arr[3] = 2, 5 > 2*2
(0, 4), arr[0] = 5, arr[4] = 2, 5 > 2*2
Constraints:
1 ≤ arr.size() ≤ 5*104
1 ≤ arr[i] ≤ 109 */

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
        
        System.out.println("Total Reverse Pairs are: "+countRevPairs(arr));
        sc.close();
    }

    public static int countRevPairs(int[] arr) {
        // code here
        return mergeSort(arr, 0, arr.length-1);
        
    }
    static int mergeSort(int arr[], int low, int high){
        int mid = low+(high-low)/2;
        int count = 0;
        if(low<high){
            count+=mergeSort(arr, low, mid);
            count+=mergeSort(arr, mid+1, high);
            count+=countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }
    static int countPairs(int arr[], int low, int mid, int high){
        int right = mid+1, count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high&&arr[i]>2*arr[right])right++;
            
            count+=right-(mid+1);
        }
        return count;
    }
    static void merge(int arr[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer> merged = new ArrayList<>();
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                merged.add(arr[left]);
                left++;
            }
            else{
                merged.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            merged.add(arr[left]);
            left++;
        }
        while(right<=high){
            merged.add(arr[right]);
            right++;
        }
        
        for(int i=low;i<=high;i++)
        arr[i]=merged.get(i-low);
    }

}