import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Prefix: ");
        String postfix = sc.nextLine();
        System.out.println("Infix is: "+prefixToInfix(postfix));
        sc.close();
    }
    static String prefixToInfix(String str){
        Stack<String>st  = new Stack<>();
        int n = str.length();
        for(int i = n-1;i>=0;i--){
            if((str.charAt(i)>='A'&&str.charAt(i)<='Z')||(str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='0'&&str.charAt(i)<='9'))st.push(Character.toString(str.charAt(i)));
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con  = '('+t1+str.charAt(i)+t2+')';
                st.push(con);
            }
        }
        return st.peek();
    }
}