/*Arranging the array
Difficulty: MediumAccuracy: 37.41%Submissions: 72K+Points: 4
You are given an array of size N. Rearrange the given array in-place such that all the negative numbers occur before all non-negative numbers.
(Maintain the order of all -ve and non-negative numbers as given in the original array).

Example 1:

Input:
N = 4
Arr[] = {-3, 3, -2, 2}
Output:
-3 -2 3 2
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 3, 2. 
Example 2:

Input:
N = 4
Arr[] = {-3, 1, 0, -2}
Output:
-3 -2 1 0
Explanation:
In the given array, negative numbers
are -3, -2 and non-negative numbers are 1, 0.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function Rearrange() which takes the array Arr[] and its size N as inputs and returns the array after rearranging with spaces between the elements of the array.

Expected Time Complexity: O(Nlog(N))
Expected Auxiliary Space: O(log(N))

Constraints:
1 ≤ N ≤ 105
-109 ≤ Elements of array ≤ 109 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the elements: ");
        
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        Rearrange(arr, n);

        System.out.println("After rearranging (-ve elements pehle, positive baad mei, not sorted order same rehna chahiye): ");

        for(int ele: arr)
        System.out.print(ele+" ");

        sc.close();
    }
    public static void Rearrange(int a[], int n) {
        // Your code goes here
        mergeSort(a,0,n-1);
        
        
    }
    static void mergeSort(int arr[], int low, int high){
        if(low>=high)return;
        int mid  = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1, high);
        merge(arr, low, mid, high);
        
    }
    static void merge(int arr[], int low, int mid, int high){
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        
        for (int i = low; i <= mid; i++) 
        if (arr[i] < 0) temp.add(arr[i]);
        

       
        for (int i = mid + 1; i <= high; i++) 
        if (arr[i] < 0) temp.add(arr[i]);
        

   
        for (int i = low; i <= mid; i++) 
        if (arr[i] >= 0) temp.add(arr[i]);
        


        for (int i = mid + 1; i <= high; i++) 
        if (arr[i] >= 0) temp.add(arr[i]);
        

        
        for(int i = low; i<=high;i++)
        arr[i]=temp.get(i-low);
    }
}