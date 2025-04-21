/*Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.

Note: It is guaranteed that there is a repeating element present in the array.

Examples:

Input: arr[] = [1, 3, 2, 3, 4]
Output: 3 
Explanation: The number 3 is the only repeating element.
Input: arr[] = [1, 5, 1, 2, 3, 4]
Output: 1  
Explanation: The number 1 is the only repeating element.
Input: arr[] = [1, 1]  
Output: 1
Explanation: The array is of size 2 with both elements being 1, making 1 the repeating element.
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ n-1 

 */
import java.util.*;

class Solution {
    public static int findDuplicate(int[] arr) {
         Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))map.put(arr[i],map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        for(var ele:map.entrySet())if(ele.getValue()>1)return ele.getKey();
        
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