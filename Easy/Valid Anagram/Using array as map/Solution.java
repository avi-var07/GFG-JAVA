/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case? */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start String: ");
        String str = sc.nextLine();
        System.out.println("Enter Goal String: ");
        String goal =sc.nextLine();

        System.out.println(isAnagram(str, goal));
        
        sc.close();
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;

        int arr[] = new int[26];

        for(int i =0;i<s.length();i++)arr[s.charAt(i)-'a']++;
        for(int i =0;i<t.length();i++){
            arr[t.charAt(i)-'a']--;
            if(arr[t.charAt(i)-'a']<0)return false;
        }
        return true;
    }
}