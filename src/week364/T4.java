package week364;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4 {
    List<Integer>[] g;
    static int N=100000;
    static boolean[] prime=new boolean[N+1];
    int[] size;
    static {
        prime[1]=true;
        for(int i=2;i<=N;i++){
            if(!prime[i]){
                for(int j=i*i;j<=Math.sqrt(N);j+=i){
                    prime[j]=true;
                }
            }
        }
    }
    public long countPaths(int n, int[][] edges) {
        g=new ArrayList[n+1];
        size=new int[n+1];
        long res=0;
        Arrays.setAll(g,e->new ArrayList<>());
        for(int[] edge:edges){
            int x=edge[0],y=edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        List<Integer> nodes=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(prime[i])continue;
            long sum=0;
            for(int x:g[i]){
                if(!prime[x])continue;
                if(size[x]==0) {
                    nodes.clear();
                    dfs(x, -1, nodes);
                    for (int j : nodes) {
                        size[j] = nodes.size();
                    }
                }
                res+=sum*(long)size[x];
                sum+=size[x];
            }
            res+=sum;
        }
        return res;
    }

    public void dfs(int x,int fa,List<Integer> nodes){
        nodes.add(x);
        for(int y:g[x]){
            if(prime[y]&&y!=fa){
                dfs(y,x,nodes);
            }
        }
    }
}
