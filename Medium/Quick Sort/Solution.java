import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements: ");

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        quickSort(arr, 0, n-1);

        for(int ele: arr)
        System.out.print(ele+" ");

        sc.close();
    }
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low<high){
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
        
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while(i<j){
            while(arr[i]<=pivot&&i<=high-1)i++;
            while(arr[j]>pivot&&j>=low+1)j--;
            
            if(i<j){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        
        int temp = arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        
        return j;
        // your code here
    }
}