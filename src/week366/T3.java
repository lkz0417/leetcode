package week366;

import java.util.Arrays;

public class T3 {
    int[][][] memo;
    public int minOperations(String s1, String s2, int x) {
        char[] c1=s1.toCharArray(),c2=s2.toCharArray();
        int n=s1.length();
        memo=new int[n][n+1][2];
        int diff=0;
        for(int i=0;i<n;i++){
            if(c1[i]!=c2[i])diff++;
        }
        if(diff%2==1)return -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return dp(c1,c2,x,n-1,0,0);
    }
    public int dp(char[] c1,char[] c2,int x,int i,int j,int prev){
        if(i<0){
            if(j>0||prev>1)return Integer.MAX_VALUE/2;
            return 0;
        }
        if(memo[i][j][prev]!=-1)return memo[i][j][prev];
        if((c1[i]==c2[i])==(prev==0))return memo[i][j][prev]=dp(c1,c2,x,i-1,j,0);
        int res=Math.min(dp(c1,c2,x,i-1,j+1,0)+x,dp(c1,c2,x,i-1,j,1)+1);
        res=Math.min(res,dp(c1,c2,x,i-1,j-1,0));
        return memo[i][j][prev]=res;
    }
}
