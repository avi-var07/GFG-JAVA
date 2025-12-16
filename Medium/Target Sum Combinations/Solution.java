/*Given an array arr[] of distinct integers and a target, your task is to find all unique combinations in the array where the sum is equal to target. The same number may be chosen from the array any number of times to make target.

Note: You can return your answer in any order, but the driver code will print the combinations in sorted order only.

Examples:

Input: arr[] = [1, 2, 3], target = 5
Output: [[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [2, 3]]
Explanation: All the combination have sum of elements equals to target.
Input: arr[] = [2, 4], target = 1
Output: []
Explanation: No combination exits whose sum is equals to target.
Constraints:
1 ≤ arr.size() ≤ 30
1 ≤ arr[i] ≤ 40
1 ≤ target ≤ 40

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

        System.out.println("Enter target: ");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>>ans = targetSumComb(arr, target);
        for(var ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        // code here    
        Arrays.sort(arr);
        ArrayList<Integer>ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        generate(arr,target,0,ds,ans);
        return ans;
        
    }
    static void generate(int arr[], int target, int index, ArrayList<Integer>ds, ArrayList<ArrayList<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(target<0)return;
        for(int i = index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            if(target<arr[i])break;
            ds.add(arr[i]);
            generate(arr,target-arr[i], i,ds,ans);
            ds.remove(ds.size()-1);
            
        }
    }
}