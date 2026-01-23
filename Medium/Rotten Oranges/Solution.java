import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter number of cols: ");
        int m = sc.nextInt();

        System.out.println("Enter "+(n*m)+" elements: ");
        int arr[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)arr[i][j]=sc.nextInt();
        }

        System.out.println(orangesRot(arr));
        sc.close();
    }
    static class Pair{
        int row, col, time;
        Pair(int row, int col, int time){
            this.row=row;
            this.col = col;
            this.time = time;
        }
    }
    public static int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair>queue = new LinkedList<>();
        int countFresh = 0;
        for(int i=0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(mat[i][j]==1)countFresh++;
                else if(mat[i][j]==2){
                    queue.add(new Pair(i,j, 0));
                    vis[i][j]=2;
                }
                else vis[i][j]=0;
            }
        }
        int ans = 0;
        int drow[]={-1,1,0,0};
        int dcol[] ={0,0,1,-1};
        int cnt=0;
        while(!queue.isEmpty()){
            Pair p =queue.poll();
            int r = p.row;
            int c= p.col;
            int t = p.time;
            ans=Math.max(ans,t);
            
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&mat[nrow][ncol]==1&&vis[nrow][ncol]!=2){
                    queue.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
                
            }
            
            
        }
        if(cnt!=countFresh)return -1;
        return ans;
        
    }
}