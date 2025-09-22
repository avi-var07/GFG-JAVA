/*Given a string s, reverse the string without reversing its individual words. Words are separated by dots(.).

Note: The string may contain leading or trailing dots(.) or multiple dots(.) between two words. The returned string should only have a single dot(.) separating the words, and no extra dots should be included.

Examples :

Input: s = "i.like.this.program.very.much"
Output: "much.very.program.this.like.i"
Explanation: The words in the input string are reversed while maintaining the dots as separators, resulting in "much.very.program.this.like.i".
Input: s = "..geeks..for.geeks."
Output: "geeks.for.geeks"
Explanation: After removing extra dots and reversing the whole string, the input string becomes "geeks.for.geeks".
Input: s = "..home....."
Output: "home"
Explanation: The input string contains only one word with extra dots around it. After removing the extra dots, the output is "home".
Constraints:
1 ≤ s.length() ≤ 106
String s contains only lowercase English alphabets and dots. */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        
        System.out.println(reverseWords(str));

        
        sc.close();
    }
    public static String reverseWords(String s) {
        // Code here
        String arr[] = s.split("\\.");
        StringBuilder ans = new StringBuilder();
        for(int i = arr.length-1; i>=0;i--){
            if(arr[i].length()==0)continue;
            if(ans.length()==0)ans.append(arr[i]);
            else{
                ans.append(".");
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }
}