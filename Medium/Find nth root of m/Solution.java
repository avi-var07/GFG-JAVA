/*You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then return -1.

Examples :

Input: n = 3, m = 8
Output: 2
Explanation: 23 = 8
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not integer.
Input: n = 4, m = 16
Output: 2
Explanation: 24 = 16
Constraints:
1 ≤ n ≤ 9
0 ≤ m ≤ 20 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Enter m: ");
        int m = sc.nextInt();

        System.out.println(nthRoot(n, m));
        
        sc.close();
    }
    public static int nthRoot(int n, int m) {
        // code here
        if(m==0)return 0;
        
        int low = 1, high = m;
        while(low<=high){
            int mid = low+(high-low)/2;
            long ans = 1;
            for(int i=1;i<=n;i++){
                ans*=mid;
                if(ans>m)break;
            }
            if(ans==m)return mid;
            else if(ans<m)low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}