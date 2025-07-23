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
        
        System.out.println("Number of subarrays with 0 Sum are: "+findSubarray(arr));
        
        sc.close();
    }
    public static int findSubarray(int[] arr) {
        // code here.
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            prefixSum+=arr[i];
            if(prefixSum==0)count++;
            
            if(map.containsKey(prefixSum))count+=map.get(prefixSum);
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}