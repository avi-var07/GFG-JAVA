/*You are given a collection of numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to the target. Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.


Example:

Input:  candidates = [10,1,2,7,6,1,5], target = 8. 
Output:  [[1,1,6], [1,2,5], [1,7], [2,6]]. 
Explanation:  These are the unique combinations whose sum is equal to the target.
Your Task:
Complete the function vector> combinationSum2(), which takes a vector "candidates" and an integer target and returns a vector of vector consisting of all unique combinations whose sum is equal to the target.


Expected Time Complexity: O(2n).
Expected Auxiliary Space: O(N).


Constraints:
1 <= candidates.length <= 100.
1 <= candidates[i] <= 50.
1 <= target <= 30. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter target: ");
        int target = sc.nextInt();
        List<List<Integer>>ans = combinationSum2(arr,target);
        for(var ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Arrays.sort(a);
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        solve(a,s,ds,ans,0);
        return ans;
        
    }
    static void solve(int arr[], int s, List<Integer>ds, List<List<Integer>>ans, int index){
        if(s==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        if(s<0)return;
        
        for(int i=index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            
            if(s<arr[i])break;
            ds.add(arr[i]);
            solve(arr,s-arr[i],ds,ans,i+1);
            ds.remove(ds.size()-1);
        }
        
    }
}