import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();

        System.out.println("Enter the elements: ");
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        List<Integer> result = findTwoElement(arr);
        System.out.println("Missing and repeating is: "+result);

        sc.close();
    }
    static ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int current=arr[i]-1;
            if(arr[i]!=arr[current]){
                int temp=arr[i];
                arr[i]=arr[current];
                arr[current]=temp;
            }
            else i++;
        }
        for(int j=0;j<arr.length;j++)if(arr[j]!=j+1){
            ans.add(arr[j]);
            ans.add(j+1);
        }
        return ans;
    }
}