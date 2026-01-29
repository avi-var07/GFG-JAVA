/*Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
Constraints:
2  ≤  V  ≤  5 x 103
1  ≤  E = edges.size()  ≤  min[105, (V * (V - 1)) / 2]
0 ≤ edges[i][0], edges[i][1] < V

 */

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
        ArrayList<Integer>ans = topoSort(V, arr);
        for(int ele: ans)System.out.print(ele+ " ");
        

        sc.close();
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean visited[] = new boolean[V];
        Stack<Integer>st = new Stack<>();
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges)adj.get(e[0]).add(e[1]);
        
        for(int i=0;i<V;i++)if(!visited[i])dfs(i,visited,adj, st);
        
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        while(!st.isEmpty())ans.add(st.pop());
        
        return ans;
    }
    
    static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>>adj, Stack<Integer>st){
        visited[node]=true;
        
        for(int e: adj.get(node))if(!visited[e])dfs(e,visited,adj,st);
        
        st.push(node);
    }
}