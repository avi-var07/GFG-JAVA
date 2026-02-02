/*Given a string s, find the length of the longest substring without repeating characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: Longest substring is "eksforg".
Input: s = "abdefgabef"
Output: 6
Explanation: Longest substring are "abdefg" , "bdefga" and "defgab".
Input: s = "aaaaa"
Output: 1
Explanation: Longest substring is "a".
Constraints:
1 ≤ s.size() ≤ 105
It is guaranteed that all characters of the String s will be lowercase letters from 'a' to 'z' */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(longestUniqueSubstring(s));
        
        sc.close();
    }
    static int longestUniqueSubstring(String s) {
        // code here
        int l=0, r=0;
        int n = s.length();
        int ans = 0;
        int hash[] = new int[26];
        while(r<n){
            char ch = s.charAt(r);
            hash[ch-'a']++;
            while(hash[ch-'a']>1){
                hash[s.charAt(l)-'a']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}