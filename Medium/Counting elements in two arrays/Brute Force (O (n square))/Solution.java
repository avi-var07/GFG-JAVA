/*
You are given two unsorted arrays a[] and b[]. Both arrays may contain duplicate elements. For each element in a[], your task is to count how many elements in b[] are less than or equal to that element.

Examples:

Input: a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
Output: [5, 6, 6, 6, 3]
Explanation: 
For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are ≤ 4.
For a[1] = 8 and a[2] = 7, there are 6 elements in b that are ≤ 8 and ≤ 7.
For a[3] = 5, there are 6 elements in b that are ≤ 5.
For a[4] = 1, there are 3 elements in b (0, 1, 1) that are ≤ 1.
Input: a[] = [10, 20], b[] = [30, 40, 50]
Output: [0, 0]
Explanation: 
For a[0] = 10 and a[1] = 20, there are no elements in b that are less than or equal to 10 or 20. Hence, the output is [0, 0].
Constraints:
1 ≤ a.size(), b.size() ≤ 105
0 ≤ a[i], b[j] ≤ 105
 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements of first array: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements of first array:");
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr1[i] = sc.nextInt();
        System.out.println("Enter number of elements of second array: ");
        int m = sc.nextInt();
        System.out.println("Enter " + m + " elements of second array:");
        int arr2[] = new int[m];
        for(int i = 0; i < m; i++) 
        arr2[i] = sc.nextInt();
        ArrayList<Integer> ans = countLessEq(arr1, arr2);
        for(int ele: ans)
        System.out.print(ele+" ");
        sc.close();
    }
    static ArrayList<Integer> countLessEq(int a[], int b[]){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele: a){
            int count= 0;
            for(int num:b){
                if(num<=ele)count++;
            }
            ans.add(count);
        }
        return ans;
    }
    
}