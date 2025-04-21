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