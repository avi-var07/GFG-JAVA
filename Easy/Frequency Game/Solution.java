import java.util.*;

class Solution {
    // Function to find largest number with minimum frequency
    public static int LargButMinFreq(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]))map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        
        int miniFreq = map.get(arr[0]);  //freq of first element, getKey() and getValue does not accept any parameter
        
        int maxi  =arr[0];
        
        for(var ele : map.entrySet()){
            if(ele.getValue()<miniFreq){
                miniFreq=ele.getValue();    //agar minifreq se less freq hai to uski freq aur key store krli
                maxi = ele.getKey();
            }
            
            else if(ele.getValue()==miniFreq && ele.getKey()>maxi)  //agar kisi aur key ki freq same ahi minifreq se and key bada hai maxi se to maxi mei key aajayegi 
            maxi=ele.getKey();
        }
        
        return maxi;
        
 
   }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    int result = LargButMinFreq(arr, n);
    System.out.println("The largest number with minimum frequency is: " + result);
    sc.close();
    
   }
}