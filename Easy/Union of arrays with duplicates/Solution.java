/*You are given two arrays a[] and b[], return the Union of both the arrays in any order.

The Union of two arrays is a collection of all distinct elements present in either of the arrays. If an element appears more than once in one or both arrays, it should be included only once in the result.

Note: Elements of a[] and b[] are not necessarily distinct.
Note that, You can return the Union in any order but the driver code will print the result in sorted order only.

Examples:

Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
Output: [1, 2, 3]
Explanation: Union set of both the arrays will be 1, 2 and 3.
Input: a[] = [1, 2, 3], b[] = [4, 5, 6] 
Output: [1, 2, 3, 4, 5, 6]
Explanation: Union set of both the arrays will be 1, 2, 3, 4, 5 and 6.
Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1] 
Output: [1, 2]
Explanation: Union set of both the arrays will be 1 and 2.
Constraints:
1 ≤ a.size(), b.size() ≤ 106
0 ≤ a[i], b[i] ≤ 105 */

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

        ArrayList<Integer> result = findUnion(arr1, arr2);

        System.out.println("Union of the two arrays are: ");
        for(int ele: result)
        System.out.print(ele+" ");
        
        
        sc.close();
    }
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i = 0, j = 0;
        while(i<a.length&& j<b.length){
            if(a[i]<b[j]){
                if(ans.size()==0 || ans.get(ans.size()-1)!=a[i])ans.add(a[i]);
                i++;
            }
            else if(b[j]<a[i]){
                if(ans.size()==0 || ans.get(ans.size()-1)!=b[j])ans.add(b[j]);
                
                j++;
            }
            else{
                if(ans.size()==0||ans.get(ans.size()-1)!=a[i])ans.add(a[i]);
                i++;
                j++;
            }
        }
        
        while(i<a.length){
            if(ans.size()==0||ans.get(ans.size()-1)!=a[i])ans.add(a[i]);
            i++;
        }
        while(j<b.length){
            if(ans.size()==0||ans.get(ans.size()-1)!=b[j])ans.add(b[j]);
            j++;
        }
        return ans;
    }
}