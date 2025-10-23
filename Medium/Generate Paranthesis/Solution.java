/*Given a number n, return all the combinations of balanced parentheses of length n.
Note: A sequence of parentheses is balanced if every opening bracket has a corresponding closing bracket in the correct order.
For example, "(())", "()()", and "(()())" are balanced, whereas ")()(", "))((", and "()))" are not.


Examples:

Input: n = 6
Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
Explanation: These are the only possible valid balanced parentheses.
Input: n = 4
Output: ["(())", "()()"]
Explanation: These are the only possible valid balanced parentheses.
Constraints:
1 ≤ n ≤ 16
n % 2 = 0

*/
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length: ");
        int n = sc.nextInt();

        ArrayList<String> list = generateParentheses(n);
        for(var ele: list)System.out.print(ele+" ");

        sc.close();
    }
    public static ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        generate(n/2,ans, "", 0, 0);
        return ans;
    }
    static void generate(int n, ArrayList<String>ans, String current, int open, int close){
        if(current.length()==2*n){
            ans.add(current);
            return;
        }
        
        if(open<n)generate(n, ans, current+"(", open+1, close);
        if(close<open)generate(n, ans, current+")", open, close+1);
    }
}