/*Geek has an array of non-overlapping intervals intervals[][] where intervals[i] = [starti , endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti . He wants to add a new interval newInterval[] = [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Examples:

Input: intervals[][] = [[1, 3], [4, 5], [6, 7], [8, 10]], newInterval[] = [5, 6]
Output: [[1, 3], [4, 7], [8, 10]]
Explanation: The newInterval [5, 6] overlaps with [4, 5] and [6, 7]. So, they are merged into one interval [4, 7].
Input: intervals[][] = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval[] = [4, 9]
Output: [[1, 2], [3, 10], [12, 16]]
Explanation: The new interval [4, 9] overlaps with [3, 5], [6, 7] and [8, 10]. So, they are merged into one interval [3, 10].
Constraints:
1 ≤ intervals.size() ≤  105
0 ≤ starti ≤ endi ≤ 109
0 ≤ newStart ≤ newEnd ≤ 109 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of intervals: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        
        for(int i=0;i<n;i++){
            System.out.println("Enter start: ");
            arr[i][0]=sc.nextInt();
            System.out.println("Enter end: ");
            arr[i][1]=sc.nextInt();
        }

        
        System.out.println("Enter new interval start: ");
        int start = sc.nextInt();
        System.out.println("Enter new interval end: ");
        int end = sc.nextInt();

        int[] newInterval = {start, end};

        ArrayList<int[]> ans = insertInterval(arr, newInterval);

        for(int ele[]: ans)
        System.out.println(ele[0]+" "+ele[1]);

        
        sc.close();
    }
    public static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int []> temp = new ArrayList<>();
        for(int []inter: intervals)
        temp.add(inter);
        
        temp.add(newInterval);
        Collections.sort(temp, (a,b) -> Integer.compare(a[0], b[0]));
        
        
        ArrayList<int []> ans = new ArrayList<>();
        
        int start = temp.get(0)[0];
        int end = temp.get(0)[1];
        
        for(int i=0;i<temp.size();i++){
            int s = temp.get(i)[0];
            int e = temp.get(i)[1];
            if(s<=end){
                if(e>end)end=e;
            }
            else{
                ans.add(new int[] {start, end});
                start=s;
                end=e;
            }
        }
        ans.add(new int[] {start, end});
        return ans;
    }
}