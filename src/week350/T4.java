package week350;

import java.util.Arrays;

public class T4 {
    public int paintWalls(int[] cost, int[] time) {
       int n=cost.length;
       int[] dp=new int[n+1];
       Arrays.fill(dp,Integer.MAX_VALUE/2);
       dp[0]=0;
       for(int i=0;i<n;i++){
           int t=time[i]+1,c=cost[i];
           for(int j=n;j>0;j--){
               dp[j]=Math.min(dp[j],dp[Math.max(0,j-t)]+c);
           }
       }
       return dp[n];
    }
}
