/*We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1], where n is the size of the stations array. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 2 decimal places.
Note: stations is in a strictly increasing order.

Example 1:

Input:
n = 10
stations[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
k = 9
Output: 0.50
Explanation: Each of the 9 stations can be added mid way between all the existing adjacent stations.
Example 2:

Input:
n = 10
stations[] = [3, 6, 12, 19, 33, 44, 67, 72, 89, 95] 
k = 2 
Output: 14.00 
Explanation: Construction of gas stations at 8th(between 72 and 89) and 6th(between 44 and 67) locations.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findSmallestMaxDist() which takes a list of stations and integer k as inputs and returns the smallest possible value of d. Find the answer exactly to 2 decimal places.

Constraint:
10 <= n <= 10000 
0 <= stations[i] <= 109 
0 <= k <= 105 */

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
        
        System.out.println("Enter number of gas stations to place: ");
        int k = sc.nextInt();
        System.out.println("Minimum among maximum distance aming adjacent gas stations is: "+findSmallestMaxDist(arr, k));
        sc.close();
    }

    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double low = 0, high = 0;
        for(int i=0;i<stations.length-1;i++){
            double diff = (double)(stations[i+1]-stations[i]);
            if(diff>high)high=diff;
        }
        
        while(high-low>1e-6){
            double mid = (low+high)/2;
            if(placed(stations, mid)>k)low=mid;
            else high=mid;
        }
        return high;
    }
    static int placed(int arr[], double dist){
        int count = 0;
        for(int i = 1; i<arr.length;i++){
            int between = (int)((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1])==(dist*between))between--;
            
            count+=between;
        }
        return count;
    }
}