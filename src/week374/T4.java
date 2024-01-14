package week374;

import java.util.Arrays;

public class T4 {
    char[] s,t;
    long[] memo;
    int sid=0;
    int[][] dis;
    Node root=new Node();
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int m= original.length,n=source.length();
        s=source.toCharArray();
        t=target.toCharArray();
        dis=new int[2*m][2*m];
        memo=new long[n];
        for(int i=0;i<2*m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE/2);
            dis[i][i]=0;
        }
        for(int i=0;i< original.length;i++){
            int x=put(original[i]),y=put(changed[i]);
            dis[x][y]=Math.min(dis[x][y],cost[i]);
        }
        for(int k=0;k<sid;k++){
            for(int i=0;i<sid;i++){
                for(int j=0;j<sid;j++){
                    if(dis[i][k]<Integer.MAX_VALUE/2&&dis[k][j]<Integer.MAX_VALUE/2&&dis[i][k]+dis[k][j]<dis[i][j]){
                        dis[i][j]=dis[i][k]+dis[k][j];
                    }
                }
            }
        }
        Arrays.fill(memo,-1);
        long ans=dfs(s,t,0);
        return ans<Long.MAX_VALUE/2?ans:-1;
    }
    public long dfs(char[] s,char[] t,int i){
        if(i>=s.length){
            return 0;
        }
        if(memo[i]!=-1)return memo[i];
        long res=Long.MAX_VALUE/2;
        if(s[i]==t[i])res=dfs(s,t,i+1);
        Node p=root,q=root;
        for(int j=i;j<s.length;j++){
            int x=s[j]-'a',y=t[j]-'a';
            p=p.son[x];
            q=q.son[y];
            if(p==null||q==null)break;;
            if(q.sid<0||p.sid<0)continue;
            if(dis[p.sid][q.sid]<Integer.MAX_VALUE/2) {
                res=Math.min(res,dis[p.sid][q.sid]+dfs(s,t,j+1));
            }
        }
        memo[i]=res;
        return memo[i];
    }

    public int put(String s){
        char[] ch=s.toCharArray();
        Node node=root;
        for(int i=0;i<ch.length;i++){
            int b=ch[i]-'a';
            if(node.son[b]==null){
                node.son[b]=new Node();
            }
            node=node.son[b];
        }
        if(node.sid<0)node.sid=sid++;
        return  node.sid;
    }

}
class Node{
    Node[] son=new Node[26];
    int sid=-1;
}

