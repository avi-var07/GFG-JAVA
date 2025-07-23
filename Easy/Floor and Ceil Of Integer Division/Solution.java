import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        
        ArrayList<Integer> result =  divFloorCeil(a, b);
        System.out.println("Floor and Ceil of the above a and b is: "+ result);
        sc.close();
    }
    public static ArrayList<Integer> divFloorCeil(int a, int b){
        ArrayList<Integer> ans = new ArrayList<>();
        double div = (double)(a/b);
        int flo = (int)(Math.floor(div));
        int ce = (int)(Math.ceil(div));
        ans.add(flo);
        ans.add(ce);
        return ans;

    }
}