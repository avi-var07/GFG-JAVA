/*You are given a string s. You have to find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
Constraints:
1 ≤ s.size() ≤ 105
s consists of lowercase english letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s =sc.nextLine();
        System.out.println(longestUniqueSubstr(s));

        
        sc.close();
    }
    public static int longestUniqueSubstr(String s) {
        // code here
        int hash[] =new int[255];
        int l=0, r=0;
        int n=s.length();
        int ans =0;
        while(r<n){
            char ch = s.charAt(r);
            hash[ch]++;
            while(hash[ch]>1){
                hash[s.charAt(l)]--;
                l++;
            }
            ans=Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}