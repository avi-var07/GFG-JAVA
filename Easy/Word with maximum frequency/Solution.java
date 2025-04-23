import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        System.out.println("Word with maximum frequency is: "+maximumFrequency(str));


        sc.close();
    }
    public static String maximumFrequency(String s) {
        // Your Code goes here
        Map<String, Integer>mp = new LinkedHashMap<>(); //to maintain order
        String str[]=s.split(" ");
        for(int i=0;i<str.length;i++){
            if(mp.containsKey(str[i]))mp.put(str[i],mp.get(str[i])+1);
            else mp.put(str[i],1);
        }
        int maxi=0;
        String key="";
        for(var ele:mp.entrySet()){
            if(ele.getValue()>maxi){
                maxi=ele.getValue();
                key=ele.getKey();
            }
        }
        return key+" "+maxi;
    }
}