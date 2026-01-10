/*You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]
Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]
Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]
Constraints:
1 ≤ s.size() ≤ 106
1 ≤ k ≤ 26 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println("Enter k: ");
        int k = sc.nextInt();
        System.out.println(countSubstr(s, k));
        
        sc.close();
    }
    public static int countSubstr(String s, int k) {
        //  code here
        return atMostk(s.toCharArray(), k) -atMostk(s.toCharArray(), k-1); 
        
    }
    static int atMostk(char s[], int k){
        int left =0, right=0;
        int count =0, ans=0;
        int n = s.length;
        int freq[] = new int[26];
        while(right<n){
            freq[s[right]-'a']++;
            if(freq[s[right]-'a']==1)count++;
            while(count>k){
                freq[s[left]-'a']--;
                if(freq[s[left]-'a']==0)count--;
                left++;
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
}