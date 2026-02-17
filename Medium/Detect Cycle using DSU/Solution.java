/*Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, the task is to check if there is any cycle in the undirected graph.

Note: Solve the problem using disjoint set union (DSU).

Examples

Input: 

Output: 1
Explanation: There is a cycle between 0->2->4->0
Input: 

Output: 0
Explanation: The graph doesn't contain any cycle
Your Task:
You don't need to read or print anyhting. Your task is to complete the function detectCycle() which takes number of vertices in the graph denoting as V and adjacency list adj and returns 1 if graph contains any cycle otherwise returns 0.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ 104

 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter V:");
        int V = sc.nextInt();
        
        System.out.println("Enter E:");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = detectCycle(V, adj);
        System.out.println(ans);
        
        sc.close();
    }

    static class DSU{
        int parent[];
        int size[];
        
        DSU(int n){
            parent=new int[n];
            size =new int[n];
            
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int findParent(int vtx){
            if(parent[vtx]==vtx)return vtx;
            
            return parent[vtx] = findParent(parent[vtx]);
        }
        boolean findUnion(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            
            if(pu==pv)return true;
            else{
                if(size[pu]>=size[pv]){ //size pu ka bada hai to pu parent banega pv ka aur merge pr size pu ka bdega kyuki usi se sb jud rhe 
                    parent[pv]=pu;
                    size[pu]+=size[pv];
                }
                else{ //pv ka size bada hai to pv parent bnega aur jod rhe to pv ka size pdega
                    parent[pu]=pv;
                    size[pv]+=size[pu];
                }
            }
            return false;
        }
    }
    public static int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        DSU d = new DSU(V);
        int n = adj.size();
  
        for(int i=0;i<n;i++){
            for(int j: adj.get(i)){
                if(i<j){
                    if(d.findUnion(i, j))return 1;
                    
                }
                
            }
        }
        
        return 0;
        
    }
}