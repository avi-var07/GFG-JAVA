/*You are given a string s that is made up of words separated by spaces. Your task is to find the word with the highest frequency, i.e. it appears the most times in the sentence. If multiple words have maximum frequency, then print the word that occurs first in the sentence.

Examples:

Input: s = "the devil in the sky"
Output: "the 2"
Explanation: The frequency of "the" is 2, so we return "the" and its frequency "2" i.e., "the 2" 
Input: s = "this is not right"
Output: "this 1"
Explanation: Every word has the frequency of "1", so we return "this 1" as this occurs first in the sentence.  */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        System.out.println("Word with maximum frequency is: "+maximumFrequency(str));


        sc.close();
    }
    public static String maximumFrequency(String s) {
        // Your Code goes here
        Map<String, Integer>mp = new LinkedHashMap<>(); //to maintain order
        String str[]=s.split(" ");
        for(int i=0;i<str.length;i++){
            if(mp.containsKey(str[i]))mp.put(str[i],mp.get(str[i])+1);
            else mp.put(str[i],1);
        }
        int maxi=0;
        String key="";
        for(var ele:mp.entrySet()){
            if(ele.getValue()>maxi){
                maxi=ele.getValue();
                key=ele.getKey();
            }
        }
        return key+" "+maxi;
    }
}