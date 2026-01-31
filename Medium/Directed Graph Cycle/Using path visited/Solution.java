/*Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from vertex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]



Output: true
Explanation: The diagram clearly shows a cycle 0 → 1 → 2 → 0
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]


Output: false
Explanation: no cycle in the graph
Constraints:
1 ≤ V ≤ 105
0 ≤ E ≤ 105
0 ≤ edges[i][0], edges[i][1] < V */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Vertices: ");
        int V = sc.nextInt();
        
        System.out.println("Enter number of edges: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(isCyclic(V, arr));
        sc.close();
    }
    public static boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges)adj.get(e[0]).add(e[1]);
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, path))return true;
            }
        }
        return false;
    }
    static boolean dfs(int node, ArrayList<ArrayList<Integer>>adj , boolean visited[], boolean path[]){
        visited[node]=true;
        path[node] = true;
        
        for(int e: adj.get(node)){
            if(!visited[e]){
                if(dfs(e, adj, visited, path))return true;
            }
            else if(path[e])return true;
        }
        
        path[node]=false;
        return false;
    }
}