package week372;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class T4 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<int[]>[] left=new ArrayList[heights.length];
        Arrays.setAll(left,e->new ArrayList<>());
        int[] ans=new int[queries.length];
        Arrays.fill(ans,-1);
        for(int qi=0;qi<queries.length;qi++){
            int i=queries[qi][0],j=queries[qi][1];
            if(i>j){
                int temp=j;
                j=i;
                i=temp;
            }
            if(i==j||heights[i]<heights[j]){
                ans[qi]=j;
            }else{
                left[j].add(new int[]{heights[i],qi});
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<heights.length;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<heights[i]){
                ans[pq.poll()[1]]=i;
            }
            for(int[] p:left[i]){
                pq.offer(p);
            }
        }
        return ans;
    }
}
