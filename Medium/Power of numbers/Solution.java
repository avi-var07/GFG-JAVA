/*Given a number n, find the value of n raised to the power of its own reverse.
Note: The result will always fit into a 32-bit signed integer.

Examples:

Input: n = 2
Output: 4
Explanation: The reverse of 2 is 2, and 22 = 4.
Input: n = 10
Output: 10
Explanation: The reverse of 10 is 1 (leading zero is discarded), and 10 raised to the power 1 is 10.
Constraints:
1 ≤ n ≤ 10 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number : ");
        int n = sc.nextInt();
        System.out.println(reverseExponentiation(n));
        sc.close();
    }
    public static int reverseExponentiation(int n) {
        // code here
        return power(n, reverse(n));
        
        
    }
    static int reverse(int n){
        int rev=0;
        while(n!=0){
            int d=n%10;
            rev=rev*10+d;
            n/=10;
        }
        return rev;
    }
    static int power(int x, int n){
        if(n==0)return 1;
        
        int temp = power(x,n/2);
        if(n%2==0)return temp*temp;
        else return x*temp*temp;
    }
}