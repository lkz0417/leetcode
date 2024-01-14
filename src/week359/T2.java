package week359;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] groups=new ArrayList[n];
        int[] dp=new int[n+1];
        Arrays.setAll(groups,e->new ArrayList<>());
        for(List<Integer> offer:offers){
            int start=offer.get(0),end=offer.get(1),gold=offer.get(2);
            groups[end].add(new int[]{start,gold});
        }
        for(int end=0;end<n;end++){
            dp[end+1]=dp[end];
            for(int[] p:groups[end]){
                dp[end+1]=Math.max(dp[end+1],dp[p[0]]+p[1]);
            }
        }
        return dp[n];
    }
}
