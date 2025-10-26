/*Given a stack of integers st[]. Sort the stack in ascending order (smallest element at the bottom and largest at the top).

Examples:

Input: st[] = [1, 2, 3]
Output: [3, 2, 1]
Explanation: The stack is already sorted in ascending order.

Input: st[] = [41, 3, 32, 2, 11]
Output: [41, 32, 11, 3, 2]
Explanation: After sorting, the smallest element (2) is at the bottom and the largest element (41) is at the top.

Constraints:
1 ≤ st.size() ≤ 103
0 ≤ stack element ≤ 103 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        System.out.println("Enter "+n+" elements: ");
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)st.push(sc.nextInt());

        System.out.println("Before sorting: ");
        for(int ele: st) System.out.print(ele+" ");
        System.out.println();
        System.out.println("After sorting: ");
        sortStack(st);
        for(int ele: st) System.out.print(ele+" ");

        sc.close();
    }
    public static void sortStack(Stack<Integer> st) {
        // code here
        if(st.size()<=1)return;
        
        int top = st.pop();
        
        sortStack(st);
        
        insertSorted(st, top);
    }
    static void insertSorted(Stack<Integer>st, int ele){
        if(st.isEmpty()||st.peek()<=ele){
            st.push(ele);
            return;
        }
        int top = st.pop();
        insertSorted(st, ele);
        st.push(top);
    }
}