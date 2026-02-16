/*Given an adjacency list, adj of Directed Graph, Find the number of strongly connected components in the graph

Examples :

Input: adj[][] = [[2, 3], [0], [1], [4], []]


Output: 3
Explanation: We can clearly see that there are 3 Strongly Connected Components in the Graph.
 
Input: adj[][] = [[1], [2], [0]]

Output: 1
Explanation: All of the nodes are connected to each other. So, there's only one SCC.
Input: adj[][] = [[1], []]
Output: 2
Constraints:
2<=adj.size()<=106
0<=edges<=adj.size()-1 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < V; i++) {
            int m = sc.nextInt();
            for(int j = 0; j < m; j++) {
                adj.get(i).add(sc.nextInt());
            }
        }

        System.out.println(kosaraju(adj));

    sc.close();
    }
    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Stack<Integer>st = new Stack<>();   //order store krne k liye final dfs call ka
        int V = adj.size();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])dfs1(i, visited, adj, st); //order store hogya stack mei!
        }
        
        ArrayList<ArrayList<Integer>>rev = new ArrayList<>();   //graph reverse krdiya
        for(int i=0;i<V;i++)rev.add(new ArrayList<>());
        
        for(int i=0;i<V;i++){
            for(int ele: adj.get(i))rev.get(ele).add(i);
        }
        Arrays.fill(visited, false);
        int count=0;
        while(!st.isEmpty()){ //ab is order se dfs call krk count krlo!
            int node = st.pop();
            if(!visited[node]){
                count++;
                dfs2(node, visited, rev);
            }
            
        }
        return count;
    }
    static void dfs1(int node, boolean visited[], ArrayList<ArrayList<Integer>>adj, Stack<Integer>st){
        visited[node]=true;
        for(int ele: adj.get(node)){
            if(!visited[ele])dfs1(ele, visited, adj, st);
        }
        st.push(node);
    }
    static void dfs2(int node, boolean visited[], ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;
        for(int ele: adj.get(node)){
            if(!visited[ele])dfs2(ele, visited, adj);
        }

    }
}