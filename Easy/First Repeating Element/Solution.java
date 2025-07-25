/* */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) 
        arr[i] = sc.nextInt();
        
        System.out.println("First repeating element is: "+firstRepeated(arr));
        sc.close();
    }
    public static int firstRepeated(int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arr)
        map.put(ele, map.getOrDefault(ele,0)+1);
        
        for(int i = 0;i<arr.length;i++){
            if(map.get(arr[i])>1)return i+1;
        }
        return -1;
    }
}