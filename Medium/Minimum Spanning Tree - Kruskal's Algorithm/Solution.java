/*Given a weighted, undirected, and connected graph with V vertices and E edges, the task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph using Kruskal's Algorithm. The graph is represented as an edge list edges[][], where edges[i] = [u, v, w] denotes an undirected edge between u and v with weight w.

Input: V = 3, E = 3, edges[][] = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

Output: 4
Explanation:

The Spanning Tree resulting in a weight of 4 is shown above.
Input: V = 2, E = 1, edges = [[0, 1, 5]]
  
Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges. */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V= sc.nextInt();

        System.out.println("Enter number of edges: ");
        int e= sc.nextInt();
        int arr[][] = new int[e][3];
        System.out.println("Enter "+e+" edges: ");
        for(int i=0;i<e;i++) {
            
            System.out.println("Enter u");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w");
            arr[i][2] = sc.nextInt();
        }

        System.out.println(kruskalsMST(V, arr));
        sc.close();
    }
    static class DSU{
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
        
        int findParent(int vtx){
            if(parent[vtx]==vtx)return vtx;
            
            return parent[vtx] = findParent(parent[vtx]);
        }
        
        boolean Union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            
            if(pu==pv)return false;  //cycle bana rha to consider kyu krna hai?
            
            else{
                if(size[pu]>=size[pv]){ //mtlb size of u ka parent bada hai size of v k parent se
                  parent[pv]=pu;
                  size[pu]+=size[pv];
                } 
                else{ //size of pv bada hai to pv parent bnega
                    parent[pu]=pv;
                    size[pv]+=size[pu];
                }
            }
            
            return true; //haa bhai thik hai koi dikkat nhi edge k sath
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        
        Arrays.sort(edges, (a,b)->(a[2]-b[2]));
        DSU d = new DSU(V);
        int sum =0;
        for(int e[]: edges){
            if(d.Union(e[0], e[1]))sum+=e[2];
        }
        
        return sum;
    }
}