import java.util.*;

class Solution {
    public static int findDuplicate(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
            else i++;
        }
        for(int j=0;j<arr.length;j++)if(arr[j]!=j+1)return arr[j];
        
        return -1;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Only repeatative is: "+findDuplicate(arr));
        sc.close();
    }
}