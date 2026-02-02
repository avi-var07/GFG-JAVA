/*Given a positive integer n, calculate and return all prime numbers less than or equal to n using the Sieve of Eratosthenes algorithm.
A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Examples:

Input: n = 10
Output: [2, 3, 5, 7]
Explanation: Prime numbers less than equal to 10 are 2, 3, 5 and 7.
Input: n = 35
Output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
Explanation: Prime numbers less than equal to 35 are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 and 31.
Constraints:
1 ≤ n ≤ 104 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int ans[] = sieve(n);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    public static int[] sieve(int n) {
        // code here
        boolean isPrime[] = new boolean [n+1];
        Arrays.fill(isPrime, true);
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i)isPrime[j]=false;
            }
        }
        int count=0;
        for(int i=2;i<=n;i++)if(isPrime[i])count++;
        int ans[]=new int[count];
        isPrime[0]=false;
        isPrime[1]=false;
        int index=0;
        for(int i=2;i<=n;i++)if(isPrime[i])ans[index++]=i;
        
        return ans;
    }
}