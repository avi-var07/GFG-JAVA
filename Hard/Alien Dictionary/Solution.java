/*A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

Examples:

Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' → 'a' → 'b' is a valid ordering.
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
Constraints:
1 ≤ words.length ≤ 500
1 ≤ words[i].length ≤ 100
words[i] consists only of lowercase English letters. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.next();

        System.out.println(findOrder(arr));
        sc.close();
    }
    public static String findOrder(String[] words) {
        // code here
        Map<Character, Integer>map = new HashMap<>();
        //no. of possible nodes mil gye
        for(String ele: words){
            for(char ch: ele.toCharArray())map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        //graph banate hai:
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<26;i++)adj.add(new ArrayList<>());
        
        int indegree[] = new int[26];
        int n = words.length;
        for(int i=0;i<n-1;i++){
            int differ =compare(words[i], words[i+1]);
            if(differ==-1&&words[i].length()>words[i+1].length())return "";
            if(differ!=-1){
                int u = words[i].charAt(differ)-'a';
                int v = words[i+1].charAt(differ)-'a';
                adj.get(u).add(v); //edge ban gaya b<a mean b->a
                indegree[v]++;
            }
        }
        
        return topoSort(adj, indegree, map);
        
    }
    static int compare(String s1, String s2){
        int m = s1.length(), n=s2.length();
        int len = Math.min(m,n);
        
        for(int i=0;i<len;i++){
            if(s1.charAt(i)!=s2.charAt(i))return i;
        }
        return -1;
    }
    static String topoSort(ArrayList<ArrayList<Integer>>adj, int indegree[], Map<Character, Integer>map){
        
        Queue<Integer>queue=  new LinkedList<>();
        for(char c: map.keySet()){
            int index = c-'a';
            if(indegree[index]==0)queue.add(index);
        }
        
        String ans="";
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans+=(char)(node+'a');
            
            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)queue.add(neighbor);
            }
            
        }
        
        if(ans.length()!=map.size())return "";
        
        return ans;
    }
}