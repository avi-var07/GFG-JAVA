import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to find sqrt: ");
        int n = sc.nextInt();

        floorSqrt(n);
        sc.close();
    }
    static int floorSqrt(int n){
        if(n==1)return 1;

        int ans = -1;
        int low = 1, high = n;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(mid*mid==n)return mid;
            else if(mid*mid<n){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}