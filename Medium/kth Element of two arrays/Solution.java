/*Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
Output: 10
Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17]. The 6th element of this array is 10.
Constraints:
1 ≤ a.size(), b.size() ≤ 106
1 ≤ k ≤ a.size() + b.size()
0 ≤ a[i], b[i] ≤ 108 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of first array: ");
        int m = sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int arr1[] = new int[m];
        for(int i = 0; i < m; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter number of elements of second array: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr2[i] = sc.nextInt();
        
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Kth Element is: "+kthElement(arr1, arr2, k));
        sc.close();
    }
    public static int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        if(n1>n2)return kthElement(b, a, k);
        int left = k;
        int low = Math.max(0, k-n2), high = Math.min(k, n1);
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = (mid1>0)?a[mid1-1]: Integer.MIN_VALUE;
            int l2 = (mid2>0)?b[mid2-1]: Integer.MIN_VALUE;
            int r1 = (mid1<n1)?a[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<n2)?b[mid2]:Integer.MAX_VALUE;
            if(l1<=r2&&l2<=r1)return Math.max(l1, l2);
            else if(l1>r2)high=mid1-1;
            else low = mid1+1;
        }
        return 0;
    }
}