/*You are given a n,m which means the row and column of the 2D matrix and an array of  size k denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each operation.You need to return an array of size k.
Note : An island means group of 1s such that they share a common side.

 

Example 1:

Input: n = 4
m = 5
k = 4
A = {{1,1},{0,1},{3,3},{3,4}}

Output: 1 1 2 2
Explanation:
0.  00000
    00000
    00000
    00000
1.  00000
    01000
    00000
    00000
2.  01000
    01000
    00000
    00000
3.  01000
    01000
    00000
    00010
4.  01000
    01000
    00000
    00011
 

 

Example 2:

Input: n = 4
m = 5
k = 4
A = {{0,0},{1,1},{2,2},{3,3}}

Output: 1 2 3 4
Explanation:
0.  00000
    00000
    00000
    00000
1.  10000
    00000
    00000
    00000
2.  10000
    01000
    00000
    00000
3.  10000
    01000
    00100
    00000
4.  10000
    01000
    00100
    00010
 

Your Task:
You don't need to read or print anything. Your task is to complete the function numOfIslands() which takes an integer n denoting no. of rows in the matrix, an integer m denoting the number of columns in the matrix and a 2D array of size k denoting  the number of operators.

Expected Time Complexity: O(m * n)
Expected Auxiliary Space: O(m * n)

Constraints:

1 <= n,m <= 100
1 <= k <= 1000

 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();
        
        System.out.println("Enter number of cols: ");
        int n = sc.nextInt();

        System.out.println("Enter number of queries: ");
        int k =sc.nextInt();
        int arr[][] = new int[k][2];
        System.out.println("Enter "+k+" elements: ");
        for(int i=0;i<k;i++) {
            System.out.println("Enter row: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter col: ");
            arr[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        List<Integer>ans = sol.numOfIslands(m, n, arr);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    class DSU{
        int parent[];
        int size[];
        
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int findParent(int x){
            if(parent[x]==x)return x;
            return parent[x] = findParent(parent[x]);
        }
        boolean union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv)return false; //need not to add already a component
            
            if(size[pu]>=size[pv]){
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
            else{
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            return true;
        }
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        
        DSU d = new DSU(rows*cols);
        boolean visited[][] = new boolean[rows][cols];
        
        int count =0;
        List<Integer>ans = new ArrayList<>();
        
        int drow[] = {-1,1,0,0};
        int dcol[] = {0,0,1,-1};
        
        for(int q[]: operators){
            int r = q[0];
            int c= q[1];
            
            if(visited[r][c]){
                ans.add(count);
                continue;
            }
            
            visited[r][c]=true;
            int index = r*cols+c;
            count++;
            
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                
                if(nrow<rows&&nrow>=0&&ncol<cols&&ncol>=0&&visited[nrow][ncol]){
                    int nbr = nrow*cols+ncol;
                    
                    if(d.union(index, nbr))count--; //agr component mei add hogya to --;
                }
            }
            ans.add(count);
        }
        return ans;
        
    }
}