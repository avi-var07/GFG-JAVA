/*You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.
Constraints:  
1 <= arr.size() <= 105
-106 <= arr[i] <= 106

 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n=sc.nextInt();
        System.out.println("Enter elements: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Smallest missing positive is: "+missingNumber(arr));
        sc.close();
    }
    public static int missingNumber(int[] arr) {
        // Your code here
        int i=0;
        while(i<arr.length){
            int current = arr[i]-1;
            if(arr[i]<=0||arr[i]>arr.length||arr[i]==arr[current])i++;
            else{
                int temp=arr[i];
                arr[i]=arr[current];
                arr[current]=temp;
            }
        }
        for(int j=0;j<arr.length;j++)if(arr[j]!=j+1)return j+1;
        
        return arr.length+1;
    }
}