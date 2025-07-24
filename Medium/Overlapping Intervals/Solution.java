/*Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1, 3] and [2, 4] which on merging will become [1, 4]. Therefore we will return [[1, 4], [6, 8], [9, 10]].
Input: arr[][] = [[6, 8], [1, 9], [2, 4], [4, 7]]
Output: [[1, 9]]
Explanation: In the given intervals all the intervals overlap with the interval [1, 9]. Therefore we will return [1, 9].
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 106 */
import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        List<int[]> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.print("Enter start: ");
            int start = sc.nextInt();
            System.out.print("Enter end: ");
            int end = sc.nextInt();
            arr.add(new int[]{start, end});
        }

        ArrayList<int[]> ans = mergeOverlap(arr.toArray(new int[arr.size()][]));

        for(int[] interval: ans)System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        
        sc.close();
    }
    public static ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int start = arr[0][0];
        int end = arr[0][1];
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 1; i<arr.length;i++){
            int s = arr[i][0];
            int e = arr[i][1];
            if(s<=end){
                if(end<e)end=e;
            }
            else{
                ans.add(new int[]{start, end});
                start=s;
                end=e;
            }
        }
        ans.add(new int[]{start, end});
        return ans;
    }

}