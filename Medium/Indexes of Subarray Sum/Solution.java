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
        ArrayList<Integer>ans = subarraySum(arr, target);
        for(var ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        int left = 0, right = 0;
        int sum =0, n=arr.length;
        while(right<n){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){
                ans.add(left+1);
                ans.add(right+1);
                return ans;
            }
            right++;
        }
        ans.add(-1);
        return ans;
    }
}