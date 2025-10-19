import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Mean is: "+mean(arr)+" Median is: "+median(arr));
        sc.close();
    }
    public static int mean(int arr[]){
        Arrays.sort(arr);
        int sum = 0;
        for(int ele: arr)sum+=ele;
        return sum/arr.length;
    }
    public static int median(int arr[]){
        Arrays.sort(arr);
        if(arr.length/2==1)return arr[arr.length/2];

        return (arr[arr.length/2]+arr[(arr.length-1)/2])/2;

    }
}
