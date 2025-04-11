import java.util.*;
class Solution {
    static int findFrequency(int arr[], int x) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        
        return map.getOrDefault(x, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to find frequency:");
        int x = sc.nextInt();
        int result = findFrequency(arr, x);
        System.out.println("Frequency of " + x + " is: " + result);
        sc.close();
    }
}