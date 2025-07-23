import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println("LCM of the numbers is: "+lcm(a, b));
        sc.close();
    }
    public static int lcm(int a, int b){
        int n1 = a, n2=b;
        int gcd = 0;
        while(a!=0&&b!=0){
            if(a>b)a%=b;
            else b%=a;
        }
        if(a==0)gcd=b;
        else gcd=a;
        return n1*n2/gcd;
    }
}