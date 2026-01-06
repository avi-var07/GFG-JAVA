/*You have given two sorted arrays arr1[] & arr2[] of distinct elements. The first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.

Examples

Input: a[] = [2,4,6,8,9,10,12], b[] = [2,4,6,8,10,12]
Output: 4
Explanation: In the first array, 9 is extra added and it's index is 4.
Input: a[] = [3,5,7,8,11,13], b[] = [3,5,7,11,13]
Output: 3
Explanation: In the first array, 8 is extra and it's index is 3.
Input: a[] = [3,5], b[] = [3]
Output: 1
Explanation: In the first array, 5 is extra and it's index is 1.
Constraints:
2<=arr1.size()<=105
1<=arr1[i],arr2[i]<=106

 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in first array: ");
        int n = sc.nextInt();

        int a[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        System.out.println("Enter number of elements in second array: ");
        int m = sc.nextInt();

        int b[] = new int[m];
        System.out.println("Enter "+m+" elements: ");
        for(int i=0;i<m;i++) b[i] = sc.nextInt();

        System.out.println(findExtra(a, b));
        sc.close();
    }
    public static int findExtra(int a[], int b[]) {
        // add code here.
        int low = 0, high = b.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(a[mid]==b[mid])low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}