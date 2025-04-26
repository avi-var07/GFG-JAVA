import java.util.*;

class Solution {
    public static int findrange(int arr[], int target, boolean isStart){
        
        int start=0, end=arr.length-1, res=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            
            if(arr[mid]==target){
                res=mid;
                if(isStart)end=mid-1;
                else start=mid+1;
                
            }
            else if(arr[mid]>target)
            end=mid-1;
            else start=mid+1;
            
        }
        
        return res;
    }
    public static int countFreq(int[] arr, int target) {
        // code here
        
        int start= findrange(arr,target, true);
        int end= findrange(arr,target, false);
        
        if(start==-1||end==-1) return 0;
        return end-start+1;
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter the target element:");
        int target = sc.nextInt();
        System.out.println("Frequency of " + target + " is: " + countFreq(arr, target));
        sc.close();
    }
}