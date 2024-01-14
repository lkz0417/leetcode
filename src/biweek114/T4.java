package biweek114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T4 {
    List<Integer>[] g;
    int n,k;
    int[] values;
    int res=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.n=n;
        this.k=k;
        this.values=values;
        g=new ArrayList[n];
        Arrays.setAll(g,e->new ArrayList<>());
        for(int[] edge:edges){
            int x=edge[0],y=edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0,-1);
        return res;
    }
    public int dfs(int node,int fa){
        int sum=values[node];
        for(int children:g[node]){
            if(children==fa)continue;
            sum+=dfs(children,node);
        }
        if(sum%k==0)res++;
        return sum;
    }
}
