/*Given an array arr[] of positive integers. Your have to sort them so that the first part of the array contains odd numbers sorted in descending order, and the rest of the portion contains even numbers sorted in ascending order.

Examples:

Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
Output: [7, 5, 3, 1, 2, 4, 10]
Explanation: 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.
Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
Output: [7, 5, 3, 1, 0, 2, 4]
Explanation: 7, 5, 3, 1 are odd numbers in descending order and 0, 2, 4 are even numbers in ascending order.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arri ≤ 109
 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        sortIt(arr);
        for(int ele: arr)System.out.print(ele+" ");
        sc.close();
    }
    public static void sortIt(int[] arr) {
        // code here
        int n = arr.length, l=0,r=n-1;
        while(l<=r){
            if(arr[l]%2==1)l++;
            else if(arr[r]%2==0)r--;
            else{
                int temp = arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }
        }
        //0 to l-1 is odd, l to n-1 is even;
        Arrays.sort(arr,0,l);
        reversal(arr,0,l-1);
        
        Arrays.sort(arr,l,n);
    }
    static void reversal(int arr[], int a, int b){
        while(a<=b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    }
}