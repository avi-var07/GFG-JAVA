import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println("Enter the size of the window:");
        int k = sc.nextInt();
        List<Integer> result = firstNegInt(arr, k);
        System.out.println("The first negative integer in each window of size " + k + " is:");
        for(int ele:result)System.out.print(ele+" ");;
        sc.close();
    }
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        
        ArrayList<Integer>result = new ArrayList<>();
        
       
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<i-k+1)
            deque.pollFirst();
            
            if(arr[i]<0)deque.offerLast(i);
            
            if(i>=k-1){
                if(!deque.isEmpty())result.add(arr[deque.peekFirst()]);
                else result.add(0);
            }
        }
        
        return result;
        
    }
}