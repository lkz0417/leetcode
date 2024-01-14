package week350;

import java.util.*;

public class T3 {
    public int specialPerm(int[] nums) {
        int n=nums.length;
        int m=(1<<n);
        final int MOD=1000000007;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(((i>>k)&1)==0&&(nums[k]%nums[j]==0||nums[j]%nums[k]==0)){
                        dp[i][j]=(dp[i^(1<<k)][k]+dp[i][j])%MOD;
                    }
                }
            }
        }
        int res=0;
        for(int k=0;k<n;k++){
            res=(res+dp[m^(1<<k)][k])%MOD;
        }
        return res;
    }
}
