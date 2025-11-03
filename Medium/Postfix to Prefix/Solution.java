import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Postfix: ");
        String postfix = sc.nextLine();
        System.out.println("Prefix is: "+postfixToPrefix(postfix));
        sc.close();
    }
    static String postfixToPrefix(String str){
        Stack<String>st  = new Stack<>();
    
        for(char ch: str.toCharArray()){
            if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')||(ch>='0'&&ch<='9'))st.push(Character.toString(ch));
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con  = ch+t2+t1;
                st.push(con);
            }
        }
        return st.peek();
    }
}