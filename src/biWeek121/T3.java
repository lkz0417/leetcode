package biWeek121;

import java.util.Arrays;

public class T3 {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y>=x){
            return y-x;
        }
        int[] dp=new int[x+12];
        int n=dp.length;
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        for(int i=1;i<=y;i++){
            dp[i]=y-i;
        }
        for(int i=y+1;i<n;i++){
            if(i%11==0){
                dp[i]=Math.min(dp[i],dp[i/11]+1);
                for(int j=i-10;j<i;j++){
                    dp[j]=Math.min(dp[j],dp[i]+i-j);
                }
            }
            if(i%5==0){
                dp[i]=Math.min(dp[i],dp[i/5]+1);
                for(int j=i-4;j<i;j++){
                    dp[j]=Math.min(dp[j],dp[i]+i-j);
                }
            }
            dp[i]=Math.min(dp[i],dp[i-1]+1);
        }
        int res=dp[x];
        for(int j=x+1;j<n;j++){
            res=Math.min(res,j-x+dp[j]);
        }
        return res;
    }
}
class test{
    public static void main(String[] args) {
        T3 test=new T3();
        int ans=test.minimumOperationsToMakeEqual(18,1);
        System.out.println(ans);
    }
}

