import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("Enter target: ");
        int tar = sc.nextInt();

        System.out.println("Number of subarrys with sum equal to the tar is: "+subArraySum(arr, tar));
        sc.close();
    }
    static int subArraySum(int arr[], int tar) {
        // add your code here
        int prefixSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==tar)count++;
            
            int remaining = prefixSum - tar;
            
            if(map.containsKey(remaining))count+=map.get(remaining);
            
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}