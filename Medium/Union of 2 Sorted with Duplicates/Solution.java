/*
Union of 2 Sorted with Duplicates
Difficulty: MediumAccuracy: 31.39%Submissions: 458K+Points: 4Average Time: 20m
Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
Examples:

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: 1 2
Explanation: Distinct elements including both the arrays are: 1 2.
Constraints:
1  <=  a.size(), b.size()  <=  105
-109  <=  a[i] , b[i]  <=  109

 */

 //Two pointer approach which is the optimal approach in this case. Brute force approach includes use of hashmap or hashset, for hashmap count frequencies and store keys into a list and return the list as ans, for hashset case since set return unique values, convert it into a list which is thereby the ans.
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array: ");
        int m = sc.nextInt();
        System.out.println("Enter the size of the second array: ");
        int n = sc.nextInt();

        int arr1[] = new int[m];
        int arr2[] = new int[n];

        System.out.println("Enter the elements of first array: ");
        for(int i=0;i<m;i++)
        arr1[i]=sc.nextInt();
        
        System.out.println("Enter the elements of second array: ");
        for(int i=0;i<n;i++)
        arr2[i]=sc.nextInt();

        System.out.println("Union of the above two array is: ");
        
        ArrayList<Integer> ans=  findUnion(arr1, arr2);
        
        for(int ele: ans)
        System.out.print(ele+" ");

        sc.close();
    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i=0, j=0;

        while(i<a.length&&j<b.length){
            if(a[i]<b[j]){
                if(ans.size()==0||ans.get(ans.size()-1)!=a[i])
                ans.add(a[i]);
                
                i++;
            }
            else if(a[i]>b[j]){
                if(ans.size()==0||ans.get(ans.size()-1)!=b[j])
                ans.add(b[j]);
                
                j++;
                
            }
            else{
                if(ans.size()==0||ans.get(ans.size()-1)!=a[i])
                ans.add(a[i]);
                
                i++;
                j++;
                
            }
        }
        
        while(i<a.length){
            if(ans.size()==0||ans.get(ans.size()-1)!=a[i])
            ans.add(a[i]);
            
            i++;
            
        }
        
        while(j<b.length){
            if(ans.size()==0||ans.get(ans.size()-1)!=b[j])
            ans.add(b[j]);
            
            j++;
            
        }
        return ans;
    }
}

//TC: O(n+m);