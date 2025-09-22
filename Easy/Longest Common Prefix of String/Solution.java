/*Given an array of strings arr[]. Return the longest common prefix among each and every strings present in the array. If there's no prefix common in all the strings, return "".

Examples :

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: "gee"
Explanation: "gee" is the longest common prefix in all the given strings.
Input: arr[] = ["hello", "world"]
Output: ""
Explanation: There's no common prefix in the given strings.
Constraints:
1 ≤ |arr| ≤ 103
1 ≤ |arr[i]| ≤ 103

 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Strings: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " Strings:");
        String arr[] = new String[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.next();
        System.out.println("Longest Common Prefix is: "+longestCommonPrefix(arr));
        
        
        sc.close();
    }

    public static String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr);
        
        String first = arr[0];
        String last  = arr[arr.length-1];
        
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<first.length();i++){
            if(last.charAt(i)!=first.charAt(i))break;
            else res.append(first.charAt(i));
        }
        return res.toString();
    }
}