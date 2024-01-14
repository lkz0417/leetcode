package week365;

import java.util.*;

public class T4 {
    List<Integer>[] rg;
    int[] g;
    int[] deg;
    int[] res;
    public int[] countVisitedNodes(List<Integer> edges) {
        int n=edges.size();
        g=new int[n];
        res=new int[n];
        for(int i=0;i<n;i++){
            g[i]= edges.get(i);
        }
        rg=new ArrayList[n];
        Arrays.setAll(rg,e->new ArrayList<Integer>());
        deg=new int[n];
        for(int i=0;i<n;i++){
            int j=g[i];
            deg[j]++;
            rg[j].add(i);
        }
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(deg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int x=g[q.poll()];
            if(--deg[x]==0){
                q.offer(x);
            }
        }
        for(int i=0;i<n;i++){
            if(deg[i]<=0)continue;;
            List<Integer> ring=new ArrayList<>();
            for(int x=i;;x=g[x]){
                ring.add(x);
                deg[x]=-1;
                if(g[x]==i)break;;
            }
            for(int r:ring){
                rdfs(ring,ring.size(),r);
            }
        }
        return res;
    }
    public void rdfs(List<Integer> ring,int depth,int root){
        res[root]=depth;
        for(int y:rg[root]){
            if(deg[y]==0){
                rdfs(ring,depth+1,y);
            }
        }
    }
}
