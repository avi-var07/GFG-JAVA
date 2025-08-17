/*Given two sorted arrays a[] and b[], find and return the median of the combined array after merging them into a single sorted array.

Examples:

Input: a[] = [3, 5, 6, 12, 15], b[] = [3, 4, 6, 10, 10, 12]
Output: 6
Explanation: The merged array is [3, 3, 4, 5, 6, 6, 10, 10, 12, 12, 15]. So the median of the merged array is 6.
Input: a[] = [2, 3, 5, 8], b[] = [10, 12, 14, 16, 18, 20]
Output: 11
Explanation: The merged array is [2, 3, 5, 8, 10, 12, 14, 16, 18, 20]. So the median of the merged array is (10 + 12) / 2 = 11.
Input: a[] = [], b[] = [2, 4, 5, 6]
Output: 4.5
Explanation: The merged array is [2, 4, 5, 6]. So the median of the merged array is (4 + 5) / 2 = 4.5.
Constraints: 
1 ≤ a.size(), b.size() ≤ 106
1 ≤ a[i], b[i] ≤ 109
a.size() + b.size() > 0 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of first array: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter number of elements of second array: ");
        int m= sc.nextInt();
        System.out.println("Enter " + m + " elements:");
        int arr2[] = new int[m];
        for(int i = 0; i < m; i++) 
        arr2[i] = sc.nextInt();

        System.out.println("Median of the two sorted arrays is: "+medianOf2(arr1, arr2));
        

        
        sc.close();
    }
    public static double medianOf2(int a[], int b[]) {
        // Code Here
        int n1 = a.length;
        int n2= b.length;
    
        int n = n1+n2;
        if(n1>n2)return medianOf2(b, a);
        int left = (n1+n2+1)/2;
        int low=0, high = n1;
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;
            int l1 = (mid1>0)?a[mid1-1]:Integer.MIN_VALUE;
            int l2 = (mid2>0)?b[mid2-1]:Integer.MIN_VALUE;
            int r1 = (mid1<n1)?a[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<n2)?b[mid2]:Integer.MAX_VALUE;

            if(l1<=r2&&l2<=r1){
                if(n%2==1){
                    if(l1>l2)return l1;
                    else return l2;
                }
                else{
                    if(l1>l2){
                        if(r1<r2)return (l1+r1)/2.0;
                        else return (l1+r2)/2.0;
                    }
                    else{
                        if(r1<r2)return (l2+r1)/2.0;
                        else return (l2+r2)/2.0;
                    }
                }
            }
            else if(l1>r2)high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }
}