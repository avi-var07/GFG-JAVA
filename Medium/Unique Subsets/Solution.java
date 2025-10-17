/*Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.

Note: Each subset should be sorted.

Example 1:

Input: N = 3, arr[] = {2,1,2}
Output:(),(1),(1 2),(1 2 2),(2),(2 2)
Explanation: 
All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2) 
Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
Example 2:

Input: N = 4, arr[] = {1,2,3,3}
Output: (),(1),(1 2),(1 2 3)
(1 2 3 3),(1 3),(1 3 3),(2),(2 3)
(2 3 3),(3),(3 3)
Your Task:
Your task is to complete the function AllSubsets() which takes the array arr[] and N as input parameters and returns list of all possible unique subsets in lexicographical order. 

Expected Time Complexity: O(2N).
Expected Auxiliary Space: O(2N * X), X = Length of each subset.

Constraints:
1 ≤ N ≤ 12
1 ≤ arr[i] ≤ 9

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

        ArrayList<ArrayList<Integer>> ans = AllSubsets(arr, n);

        for(ArrayList<Integer>list : ans)
        System.out.print(list+" ");


        sc.close();
    }
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        // your code here
        Arrays.sort(arr);
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generate(arr,0,ds,ans);
        ans.sort((a, b) -> {
            int len = Math.min(a.size(), b.size());
            for (int i = 0; i < len; i++) {
                if (!a.get(i).equals(b.get(i)))
                    return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });
        
        return ans;
        
    }
    static void generate(int arr[], int index, ArrayList<Integer>ds, ArrayList<ArrayList<Integer>>ans){
        ans.add(new ArrayList<>(ds));
        for(int i=index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            
            ds.add(arr[i]);
            generate(arr,i+1,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}