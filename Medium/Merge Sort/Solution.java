import java.util.ArrayList;
import java.util.Scanner;

class Solution {

   static void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r)return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
        
    }
    static void merge(int arr[], int l, int mid, int r){
        int left = l;
        int right = mid+1;
        
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(left<=mid&&right<=r){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=r){
            temp.add(arr[right]);
            right++;
        }
        
        for(int i=l;i<=r;i++)
        arr[i]= temp.get(i-l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements of the array: ");
        for (int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
     

        System.out.println();
        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) 
        System.out.print(arr[i] + " ");

        sc.close();
    }
}
