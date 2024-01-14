package biWeek107;

import java.util.Arrays;

public class T3 {
    public int minimizeConcatenatedLength(String[] words) {
        int n=words.length;
        int[][][] dp=new int[n][26][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE/2);
            }
        }
        dp[0][words[0].charAt(0)-'a'][words[0].charAt(words[0].length()-1)-'a']=words[0].length();
        for(int i=1;i<n;i++){
            String word=words[i];
            int len=word.length();
            int h=word.charAt(0)-'a';
            int t=word.charAt(len-1)-'a';
            for(int j=0;j<26;j++){
                for(int k=0;k<26;k++){
                    if(h==k){
                        dp[i][j][t]=Math.min(dp[i][j][t],dp[i-1][j][k]+len-1);
                    }else{
                        dp[i][j][t]=Math.min(dp[i][j][t],dp[i-1][j][k]+len);
                    }
                    if(t==j){
                        dp[i][h][k]=Math.min(dp[i][h][k],dp[i-1][j][k]+len-1);
                    }else{
                        dp[i][h][k]=Math.min(dp[i][h][k],dp[i-1][j][k]+len);
                    }
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int j=0;j<26;j++){
            for(int k=0;k<26;k++){
                res=Math.min(res,dp[n-1][j][k]);
            }
        }
        return res;
    }
}
