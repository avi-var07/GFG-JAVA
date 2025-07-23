import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Sum of the digits of the number is: "+sumOfDigits(n));
        sc.close();
    }
    static int sumOfDigits(int n){
        int sum = 0 ;
        while(n!=0){
            int d = n%10;
            sum+=d;
            n/=10;
        }
        return sum;
    }
}