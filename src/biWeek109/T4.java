package biWeek109;

import java.util.ArrayList;
import java.util.List;

public class T4 {
    public int numberOfWays(int n, int x) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<n;i++){
            int num=1;
            for(int j=0;j<x;j++){
                num*=i;
            }
            if(num<=x)list.add(num);
            else break;
        }
        int m= list.size();
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=m;i++){
            for(int j=n;j>=list.get(i-1);j--){
                dp[j]+=dp[j-list.get(i-1)];
            }
        }
        return dp[n+1];
    }
}
