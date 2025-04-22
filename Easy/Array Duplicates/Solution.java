import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n=sc.nextInt();
        System.out.println("Enter the elements :");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("The duplicates are: ");
        List<Integer> lst=findDuplicates(arr);
        for(int ele: lst)
        System.out.println(ele+" ");
        sc.close();
    }
    public static List<Integer> findDuplicates(int[] arr) {
        // code here
        List<Integer>ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))map.put(arr[i],map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        for(var ele: map.entrySet())if(ele.getValue()>1)ans.add(ele.getKey());
        
        return ans;
    }
}