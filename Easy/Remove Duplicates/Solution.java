/*Given a string s without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.

Note: The original order of characters must be kept the same. 

Examples :

Input: s = "zvvo"
Output: "zvo"
Explanation: Only keep the first occurrence
Input: s = "gfg"
Output: "gf"
Explanation: Only keep the first occurrence
Constraints:
1 <= s.size() <= 105
str contains lowercase English alphabets */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();

        System.out.println("After removing Duplicates: "+removeDups(str));
        
        sc.close();
    }
    static String removeDups(String s) {
        // code here
        Set<Character> set = new LinkedHashSet<>();
        for(char ch: s.toCharArray())set.add(ch);
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch: set)sb.append(ch);
        
        return sb.toString();
    }
}