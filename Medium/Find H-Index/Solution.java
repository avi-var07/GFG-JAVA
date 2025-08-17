/*You are given an array citations[], where each element citations[i] represents the number of citations received by the ith paper of a researcher. You have to calculate the researcher’s H-index.
The H-index is defined as the maximum value H, such that the researcher has published at least H papers, and all those papers have citation value greater than or equal to H.

Examples:

Input: citations[] = [3, 0, 5, 3, 0]
Output: 3
Explanation: There are at least 3 papers with citation counts of 3, 5, and 3, all having citations greater than or equal to 3.
Input: citations[] = [5, 1, 2, 4, 1]
Output: 2
Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
Input: citations[] = [0, 0]
Output: 0
Explanation: The H-index is 0 because there are no papers with at least 1 citation.
Constraints:
1 ≤ citations.size() ≤ 106
0 ≤ citations[i] ≤ 106 */

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
        
        System.out.println("H Index is: "+hIndex(arr));
        sc.close();
    }
    public static  int hIndex(int[] citations) {
        // code here
        int low = 0, high = citations[0];
        for(int ele: citations){
            if(ele>high)high=ele;
        }
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(count(citations, mid)>=mid){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    static int count(int arr[], int value){
        int count=0;
        for(int ele: arr){
            if(ele>=value)count++;
        }
        return count;
    }
}