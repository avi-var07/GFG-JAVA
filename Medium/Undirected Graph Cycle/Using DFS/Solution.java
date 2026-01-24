/*Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Note: The graph can have multiple component.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
 
1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
 
No cycle in the graph.
Constraints:
1 ≤ V, E ≤ 105
0 ≤ edges[i][0], edges[i][1] < V */

import java.util.*;

class Solution{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of vertices (V): ");
    int V = sc.nextInt();

    System.out.print("Enter number of edges (E): ");
    int E = sc.nextInt();

    int edges[][] = new int[E][2];

    System.out.println("Enter edges (u v):");
    for(int i = 0; i < E; i++){
        edges[i][0] = sc.nextInt();
        edges[i][1] = sc.nextInt();
    }

    System.out.println(isCycle(V, edges));

    sc.close();
    }
    static class Pair{
        int node, parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean visited[] = new boolean[V];
        
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(checkCycle(i,-1,adj, visited))return true;
            }
        }
        return false;
    }
    static boolean checkCycle(int i, int parent, ArrayList<ArrayList<Integer>>adj, boolean visited[]){
         visited[i] = true;
        
         for(int ele: adj.get(i)){
            if(!visited[ele]){
                if(checkCycle(ele, i, adj, visited))return true;
            }
            else if(parent!=ele)return true;
         }
         
         return false;
    }
}