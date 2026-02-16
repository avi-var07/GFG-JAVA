/*You are given a weighted undirected graph with n vertices numbered from 1 to n and m edges along with their weights. Find the shortest path between vertex 1 and vertex n. Each edge is given as {a, b, w}, denoting an edge between vertices a and b with weight w.

If a path exists, return a list of integers where the first element is the total weight of the shortest path, and the remaining elements are the nodes along that path (from 1 to n). If no path exists, return a list containing only {-1}.

Note: The driver code will internally verify your returned list.

If both the path and its total weight are valid, only the total weight will be displayed as output.
If your list contains only -1, the output will be -1.
If the returned list is invalid, the output will be -2.
Examples :

Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
Output: 5
Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5. 
Input: n = 2, m= 1, edges = [[1, 2, 2]]
Output: 2
Explanation: Shortest path from 1 to 2 is by the path 1 2 whose weight is 2. 
Input: n = 2, m= 0, edges = [ ]
Output: -1
Explanation: Since there are no edges, so no answer is possible.
Expected Time Complexity: O(m* log(n))
Expected Space Complexity: O(n+m)

Constraint:
2 <= n <= 106
0 <= m <= 106
1 <= a, b <= n
1 <= w <= 105

 */
import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter V: ");
        int V = sc.nextInt();

        System.out.println("Enter E: ");
        int e=sc.nextInt();
        int arr[][] = new int[e][3];
        System.out.println("Enter "+e+" edges: ");
        for(int i=0;i<e;i++) {
            
            System.out.println("Enter u: ");
            arr[i][0] = sc.nextInt();
            System.out.println("Enter v: ");
            arr[i][1] = sc.nextInt();
            System.out.println("Enter w: ");
            arr[i][2] = sc.nextInt();
        }

        List<Integer>ans = shortestPath(V, e, arr);

        for(int ele: ans)System.out.print(ele+ " ");
        sc.close();
    }
    static class Pair{
        int v, dist;
        Pair(int v, int dist){
            this.v=v;
            this.dist=dist;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer>ans = new ArrayList<>();
        
        List<List<Pair>>adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        
        for(int e[]: edges){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }
        
        int src =1, dest=n;
        
        int parent[] = new int[n+1];
        
        for(int i=0;i<=n;i++)parent[i]=i; //initialised parent
        int distance[] = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE); //initialised distance
        
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.dist-b.dist); //min heap
        pq.add(new Pair(src, 0));
        distance[src]=0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.v; //jo poll hua wo node
            int initial = p.dist; //jo poll hua uska ab tk ka dist
            
            for(Pair ele: adj.get(node)){ //poll hue node k neighbours pe jaao
                int newDist = initial+ele.dist; //neighbor ka cost abhi tk k distance mei add
                
                if(distance[ele.v]>newDist){
                    distance[ele.v]=newDist;
                    parent[ele.v]=node;
                    pq.add(new Pair(ele.v, newDist));
                }
            }
        }
        
        if(distance[dest]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int node = dest;
        while(parent[node]!=node){
            ans.add(node);
            node = parent[node];
        }
        ans.add(src);
        ans.add(distance[n]);
        Collections.reverse(ans);
        return ans;
    }
}