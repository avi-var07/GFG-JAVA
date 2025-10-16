/*Given an array arr[] of distinct positive integers, your task is to find all its subsets.

Note: You can return the subsets in any order, the driver code will print them in sorted order.

Examples:

Input: arr[] = [1, 2, 3]
Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
Explanation: 
The subsets of [1, 2, 3] in lexicographical order are:
[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]
Input: arr[] = [2, 4]
Output: [[], [2], [2, 4], [4]]
Explanation:
The subsets of [2, 4] in lexicographical order are:
[], [2], [2, 4], [4]
Constraints :
1 ≤ arr.size() ≤ 10
1 ≤ arr[i] ≤ 103 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = subsets(arr);
        for(ArrayList<Integer> ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    public static ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generate(arr,0,ds,ans);
        return ans;
        
    }
    static void generate(int arr[], int index, ArrayList<Integer>ds, ArrayList<ArrayList<Integer>>ans){
        if(index==arr.length){
            
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(arr[index]);
        generate(arr,index+1,ds,ans);
        ds.remove(ds.size()-1);
        generate(arr,index+1,ds,ans);
        
    }
}