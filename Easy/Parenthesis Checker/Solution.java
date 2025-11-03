/*Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']'. Determine whether the Expression is balanced or not.
An expression is balanced if:

Each opening bracket has a corresponding closing bracket of the same type.
Opening brackets must be closed in the correct order.
Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.
Input: s = "([{]})"
Output: false
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
Constraints:
1 ≤ s.size() ≤ 106
s[i] ∈ {'{', '}', '(', ')', '[', ']'} */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        System.out.println(isBalanced(s));
        sc.close();
    }
    public static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='[')st.push(ch);
            else{
                if(st.isEmpty())return false;
                char top = st.pop();
                if((top=='('&&ch==')')||(top=='{'&&ch=='}')||(top=='['&&ch==']'))continue;
                else return false;
            }
            
        }
        return st.isEmpty();
    }
}