/*Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.

Each hour, Koko can choose one pile and eat up to s bananas from it.

If the pile has atleast s bananas, she eats exactly s bananas.

If the pile has fewer than s bananas, she eats the entire pile in that hour.

Koko can only eat from one pile per hour.


Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

Examples:

Input: arr[] = [5, 10, 3], k = 4
Output: 5
Explanation: If Koko eats at the rate of 5 bananas per hour:
First pile of 5 bananas will be finished in 1 hour.
Second pile of 10 bananas will be finished in 2 hours.
Third pile of 3 bananas will be finished in 1 hours.
Therefore, Koko can finish all piles of bananas in 1 + 2 + 1 = 4 hours.
Input: arr[] = [5, 10, 15, 20], k = 7
Output: 10
Explanation: If Koko eats at the rate of 10 bananas per hour, it will take 6 hours to finish all the piles.
Constraint:
1 ≤ arr.size() ≤ k ≤ 106
1 ≤ arr[i] ≤ 106 */

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
        
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println("Koko can eat: "+kokoEat(arr, k)+" bananas/hour");
        sc.close();
    }

    public static int kokoEat(int[] arr, int k) {
        // code here
        int maxi = arr[0];
        for(int ele: arr){
            if(ele>maxi)maxi=ele;
        }
        
        int low = 1, ans=-1;
        while(low<=maxi){
            int mid = low+(maxi-low)/2;
            
            int total = calculateTime(arr, mid);
            if(total<=k){
                ans=mid;
                maxi=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    static int calculateTime(int arr[], int hour){
        int total = 0;
        for(int ele:  arr){
            total+=Math.ceil((double)(ele)/(double)(hour));
        }
        return total;
    }
}