package week357;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class T3 {
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int[]> queue=new LinkedList<>();
        int n=grid.size();
        if(grid.get(0).get(0)==1||grid.get(n-1).get(n-1)==1){
            return 0;
        }
        boolean[][] visited=new boolean[n][n];
        int[][] dis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dis[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] point=queue.poll();
            int x=point[0],y=point[1];
            for(int[] dir:dirs){
                int nx=x+dir[0],ny=y+dir[1];
                if(nx>=0&&ny>=0&&nx<n&&ny<y&&!visited[nx][ny]){
                    dis[nx][ny]=dis[x][y]+1;
                    visited[nx][ny]=true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        boolean[][] vis=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[2]-a[2]));
        pq.offer(new int[]{0,0,dis[0][0]});
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int x=temp[0],y=temp[1],d=temp[2];
            if(vis[x][y])continue;
            if(x==n-1&&y==n-1)return dis[x][y];
            vis[x][y]=true;
            for(int[] dir:dirs){
                int nx=x+dir[0],ny=y+dir[1];
                if(nx>=0&&ny>=0&&nx<n&&ny<n&&!vis[nx][ny]){
                    dis[nx][ny]=Math.min(dis[nx][ny],d);
                    pq.offer(new int[]{nx,ny,dis[nx][ny]});
                }
            }
        }
        return dis[n-1][n-1];
    }
}
