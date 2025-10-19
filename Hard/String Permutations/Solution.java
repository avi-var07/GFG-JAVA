/*Given a string S. The task is to find all permutations (need not be different) of a given string.

Note: return the permutations in lexicographically increasing order.

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.
Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
Explanation: There are total 24 permutations, as given in the output.
Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to generate permutations: ");
        String s = sc.nextLine();
        ArrayList<String>list = permutation(s);
        for(var ele: list)System.out.print(ele+" ");
        
        sc.close();
    }
    public static ArrayList<String> permutation(String S) {
        // Your code here
        ArrayList<String>ans = new ArrayList<>();
        char arr[] = S.toCharArray();
        generate(ans, 0,arr);
        Collections.sort(ans);
        return ans;
        
    }
    static void generate( ArrayList<String>ans, int index, char arr[]){
        if(index==arr.length){
            ans.add(new String(arr));
            return;
        }
        for(int i=index;i<arr.length;i++){
         
            swap(arr, index, i);
            generate(ans,index+1, arr);
       
            swap(arr,index, i);
        }
    }
    static void swap(char arr[], int a, int b){
        char temp  = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}