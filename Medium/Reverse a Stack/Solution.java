/*You are given a stack st[]. You have to reverse the stack.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

Input: st[] = [3, 2, 1]
Output: [3, 2, 1]
Explanation: After reversing, the elements of stack are in opposite order.

Constraints:
1 ≤ st.size() ≤ 100
0 ≤ stack element ≤ 100 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        Stack<Integer> st = new Stack<>();
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++)st.push(sc.nextInt());

        System.out.println("Original: ");
        for(int ele: st)System.out.print(ele+" ");

        reverseStack(st);
        System.out.println();
        System.out.println("After reversing: ");
        for(int ele: st)System.out.print(ele+" ");
        sc.close();
    }
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty())return;
        int top = st.pop();
        reverseStack(st);
        insert(st, top);
    }
    static void insert(Stack<Integer>st, int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        
        int top = st.pop();
        insert(st, ele);
        st.push(top);
    }
}