/*Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.
It is guaranteed that all the shortest distance will fit in a 32-bit integer.

Examples:

Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:

Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2
Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 

Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
Constraints:
1 ≤ V ≤ 106
1 ≤ E = edges.size() ≤ 106
0 ≤ edges[i][0], edges[i][1] ≤ V-1
0 ≤ edges[i][2] ≤ 104
0 ≤ src < V
 */

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();

        System.out.println("Enter number of edges: ");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];

        for(int i=0;i<e;i++){
            System.out.println("Enter u: ");
            int u = sc.nextInt();
            System.out.println("Enter v: ");
            int v = sc.nextInt();
            System.out.println("Enter w: ");
            int w = sc.nextInt();

            edges[i][0]=u;
            edges[i][1]=v;
            edges[i][2]=w;
        }

        System.out.println("Enter src: ");
        int src =sc.nextInt();

        int ans[] = dijkstra(V, edges, src);

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }
    static class Pair{
        int node;
        int wt;
        
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>>adj  =new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }
        int dist[]= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src]=0;
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;
            
            for(Pair ele: adj.get(node)){
                int newNode = ele.node;
                int newDist = ele.wt+wt;
                
                if(newDist<dist[newNode]){
                    dist[newNode]=newDist;
                    pq.add(new Pair(newNode, newDist));
                }
                
            }
        }
        return dist;
    }
}