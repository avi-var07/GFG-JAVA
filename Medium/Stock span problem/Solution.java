/*The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days.
You are given an array arr[] representing daily stock prices, the stock span for the i-th day is the number of consecutive days up to day i (including day i itself) for which the price of the stock is less than or equal to the price on day i. Return the span of stock prices for each day in the given sequence.

Examples:

Input: arr[] = [100, 80, 90, 120]
Output: [1, 1, 2, 4]
Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more days behind it so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 90 is greater than equal to 90 and 80 so the span is 2, 120 is greater than 90, 80 and 100 so the span is 4. So the output will be [1, 1, 2, 4].
Input: arr[] = [10, 4, 5, 90, 120, 80]
Output: [1, 1, 2, 4, 5, 1]
Explanation: Traversing the given input span 10 is greater than equal to 10 and there are no more days behind it so the span is 1, 4 is greater than equal to 4 and smaller than 10 so the span is 1, 5 is greater than equal to 4 and 5 and smaller than 10 so the span is 2, and so on. Hence the output will be [1, 1, 2, 4, 5, 1].
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105

 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        ArrayList<Integer> ans = calculateSpan(arr);
        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static class Pair{
        int count, value;
        Pair(int count, int value){
            this.count = count;
            this.value = value;
        }
    }
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Pair>st = new Stack<>();
        ArrayList<Integer>ans  = new ArrayList<>();
        for(int ele: arr){
            int count = 1;
            while(!st.isEmpty()&&st.peek().value<=ele)count+=st.pop().count;
                
            st.push(new Pair(count, ele));
            ans.add(count);
        }
        return ans;
    }

}