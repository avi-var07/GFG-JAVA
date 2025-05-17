// Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C. The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C. After applying this transformation to every element, return the modified array in sorted order.

// Examples:

// Input: arr[] = [-4, -2, 0, 2, 4], A = 1, B = 3, C = 5
// Output: [3, 5, 9, 15, 33]
// Explanation: After applying f(x) = 1*(x2)+ 3*x + 5 to each x, we get [9, 3, 5, 15, 33]. After sorting this array, the array becomes [3, 5, 9, 15, 33].
// Input: arr[] = [-3, -1, 2, 4], A = -1, B = 0, C = 0
// Output: [-16, -9, -4, -1]
// Explanation: After applying f(x) = -1*(x2) + 0*x + 0 to each x, we get [ -9, -1, -4, -16 ]. After sorting this array, the array becomes  [-16, -9, -4, -1].
// Constraints:
// 1 ≤ arr.size() ≤ 106
// -103 ≤ arr[i], A, B, C ≤ 103

import java.util.*;

class Solution {
    public static ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        ArrayList<Integer>ans = new ArrayList<>();
       for(int num: arr){
           num=(A*num*num)+(B*num)+C;
           ans.add(num);
       }
       Collections.sort(ans);
       return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements in the array: ");
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the value of A to put in equation: ");
        int a  = sc.nextInt();
        System.out.println("Enter the value of B to put in equation: ");
        int b  = sc.nextInt();
        System.out.println("Enter the value of C to put in equation: ");
        int c  = sc.nextInt();
        ArrayList<Integer> result = sortArray(arr, a,b,c);
        for(int num: result)System.out.print(num+" ");
        sc.close();
    }
}