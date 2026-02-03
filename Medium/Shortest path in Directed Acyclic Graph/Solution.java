/*Given a Directed Acyclic Graph of V vertices from 0 to n-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Examples :

Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
Output: [0, 2, 1, -1]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->2 with edge weight 1. There is no way we can reach 3, so it's -1 for 3.
Input: V = 6, E = 7, edges = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]
Output: [0, 2, 3, 6, 1, 5]
Explanation: Shortest path from 0 to 1 is 0->1 with edge weight 2. Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3. Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6. Shortest path from 0 to 4 is 0->4 with edge weight 1.Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
Constraint:
1 <= V <= 100
1 <= E <= min((N*(N-1))/2,4000)
0 <= edgesi,0, edgesi,1 < n
0 <= edgei,2 <=105 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();
        
        System.out.println("Enter E: ");
        int E= sc.nextInt();

        int arr[][] = new int[E][3];
        System.out.println("Enter "+E+" elements: ");
        for(int i=0;i<E;i++) {
            System.out.println("Enter u: ");
            int u = sc.nextInt();
            System.out.println("Enter v: ");
            int v = sc.nextInt();
            System.out.println("Enter w: ");
            int w = sc.nextInt();
            arr[i][0] = u;
            arr[i][1] = v;
            arr[i][2] = w;
        }

        int ans[] = shortestPath(V, E, arr);

        for(int ele: ans)System.out.print(ele+" ");

        sc.close();
    }
    static class Pair{
        
        int v, w;
        Pair(int v, int w){
            this.v=v;
            this.w=w;
        }
    }
    public static int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        boolean visited[] = new boolean[V];
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>(); //sbse pehle adj list banayi
        
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            
            adj.get(u).add(new Pair(v,w));
        }
        
        Stack<Integer>st = new Stack<>(); //topo sort laga rhe
        for(int i=0;i<V;i++){
            if(!visited[i])dfs(i, visited, adj, st);
        }
        //stack mei topo sort order aagaya
        Integer dist[] = new Integer[V];
        int src = 0;
        dist[src] = 0; //0 k liye 0 dist hogi
        while(!st.isEmpty()){
            int node = st.pop();
            if(dist[node]==null)continue;
            
            for(Pair ele: adj.get(node)){ //pop kiya->usk neighbor pe gaye-> dist calculate kiya
                int wt = ele.w; //neighbor pe jaane ka cost
                int initial = dist[node]; //pop wala ka distance 
                int newDist = initial+wt;
                
                if(dist[ele.v]==null)dist[ele.v]=newDist;
                else if(dist[ele.v]>newDist)dist[ele.v]=newDist;
                else continue;
            }
        }
   
        int ans[] = new int[V];

        for(int i=0;i<V;i++){
            if(dist[i]==null)ans[i]=-1;
            else ans[i]=dist[i];
        }
        return ans;
    }
    static void dfs(int node, boolean visited[], ArrayList<ArrayList<Pair>>adj, Stack<Integer>st){
        visited[node]=true;
        
        for(Pair ele: adj.get(node)){
            if(!visited[ele.v])dfs(ele.v, visited, adj, st);
        }
        st.push(node);
    }
}