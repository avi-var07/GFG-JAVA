/*You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String s: ");
        String s = sc.nextLine();
        System.out.println("Enter k: ");
        int k =sc.nextInt();

        System.out.println(longestKSubstr(s, k));
        sc.close();
    }
    public static int longestKSubstr(String s, int k) {
        // code here
        int n =s.length();
        int left=0, right=0;
        int maxi = -1;
        Map<Character, Integer>map = new HashMap<>();
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c)==0)map.remove(c);
                left++;
            }
            if(map.size()==k)maxi = Math.max(maxi, right-left+1);
            right++;
        }
        return maxi;
    }
}