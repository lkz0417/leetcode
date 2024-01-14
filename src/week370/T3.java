package week370;

import java.util.ArrayList;
import java.util.List;

public class T3 {
    long[] sum;
    List<Integer>[] graph;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n= values.length;
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        sum=new long[n];
        sumOfSubtree(0,values);
        return dfs(0,values);
    }

    public int sumOfSubtree(int index,int[] values){
        List<Integer> children=graph[index];
        int total=values[index];
        for(int child:children){
            if(child==index)continue;
            total+=sumOfSubtree(child,values);
        }
        sum[index]=total;
        return total;
    }

    public int dfs(int root,int[] values){
        int choose=values[root];
        int noChoose=0;
        List<Integer> children=graph[root];
        if(children.size()==1){
            return 0;
        }
        for(int child:children){
            if(child==root)continue;
            choose+=dfs(child,values);
            noChoose+=sum[child];
        }
        return Math.max(noChoose,choose);
    }

}
