/*Given an array of integers arr[]. You have to find the Inversion Count of the array. 
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

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
        
        System.out.println("Number of Inversions: "+inversionCount(arr));
        
        sc.close();
    }
    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr, 0, arr.length-1);
        
    }
    static int mergeSort(int arr[], int low, int high){
        int mid = (low+high)/2;
        int count=0;
        if(low<high){
            count+=mergeSort(arr, low, mid);
            count+=mergeSort(arr, mid+1, high);
            count+=merge(arr, low, mid, high);
        }
        else return count;
        
        return count;
        
    }
    static int merge(int arr[], int low, int mid, int high){
        int left = low;
        int right= mid+1;
        
        int count =0;
        
        ArrayList<Integer> temp = new ArrayList<>();
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                count+= mid-left+1;
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
        
        for(int i=low;i<=high;i++)
        arr[i]=temp.get(i-low);
        
        return count;
    }
    
}