/*You are given an array arr[] of positive integers (which may contain duplicates), your task is to find all the unique subsets of the array.

Note: You can return the subsets in any order, the driver code will print them in sorted order.

Examples:

Input: arr[] = [1, 5, 6]
Output: [[], [1], [1, 5], [1, 5, 6], [1, 6], [5], [5, 6], [6]]
Explanation: The number of all the possible subsets will be 2n.
Now the unique subsets are [], [1], [1, 5], [1, 5, 6], [1, 6], [5], [5, 6], [6].
Input: arr[] = [1, 2, 2]
Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
Explanation: The number of all the possible subsets will be 2n.
Now the unique subsets are [], [1], [1, 2], [1, 2, 2], [2], [2, 2].
Constraints
1 ≤ arr.size() ≤ 15
1 ≤ arr[i] ≤  105 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = findSubsets(arr);
        for(ArrayList<Integer> ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generate(arr,0,ds,ans);
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