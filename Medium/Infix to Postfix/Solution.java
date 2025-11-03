import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix String: ");

        String s = sc.nextLine();

        String res = infixToPostfix(s, "");

        System.out.println("Postfix is: "+res);
        sc.close();
    }
    static String infixToPostfix(String s, String ans){
        Stack<Character>st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')||(ch>='0'&&ch<='9'))ans+=ch;
            else if(ch=='(')st.push(ch);
            else if(ch==')'){
                while(!st.isEmpty()&&st.peek()!='(')ans+=st.pop();

                st.pop();
            }
            else{
                while(!st.isEmpty()&&(priority(ch)<=priority(st.peek())))ans+=st.pop();

                st.push(ch);
            }
        }

        while(!st.isEmpty())ans+=st.pop();

        return ans;
    }
    static int priority(char ch){
        if(ch=='^')return 3;
        if(ch=='*'||ch=='/')return 2;
        if(ch=='+'||ch=='-')return 1;

        return -1;

    }
}