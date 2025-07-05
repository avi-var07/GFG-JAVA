/*Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

Note: It is guaranteed that the answer fits in a 32-bit integer.

Examples

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
Constraints:
1 ≤ arr.size() ≤ 106
-10  ≤  arr[i]  ≤  10



*/

//Kadane's Like Algorithm. -ve*-ve = +ve, -ve*+ve = -ve and anything with 0 = 0. So we need to keep track on the -ve. When found swap it with currMax.

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
        
        System.out.println("Maximum Product is: "+maxProduct(arr));
        sc.close();
    }

    static int maxProduct(int[] arr) {
        // code here
            int n = arr.length;

            int currMax = arr[0];
            int currMin = arr[0];
            int maxProd = arr[0];
        
            for (int i = 1; i < n; i++) {
                int num = arr[i];
        
                if (num < 0) {
                    // negative se sign ulta ho jaata hai
                    int temp = currMax;
                    currMax = currMin;
                    currMin = temp;
                }
        
                currMax = Math.max(num, currMax * num);
                currMin = Math.min(num, currMin * num);
        
                maxProd = Math.max(maxProd, currMax);
            }
        
            return maxProd;

    }
}