package biWeek121;

import java.util.Arrays;

public class t4 {
    char[] low,high,s;
    int limit;
    long[] memo;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s=s.toCharArray();
        this.limit=limit;
        high=Long.toString(finish).toCharArray();
        int n=high.length;
        String left=Long.toString(start);
        left="0".repeat(n-left.length())+left;
        low=left.toCharArray();
        memo=new long[n];
        Arrays.fill(memo,-1);
        return dfs(0,true,true);
    }

    public long dfs(int i,boolean isLowLimit,boolean isHighLimit){
        if(i==high.length){
            return 1;
        }
        if(!isHighLimit&&!isLowLimit&&memo[i]!=-1)return memo[i];
        int down=isLowLimit?low[i]-'0':0;
        int up=isHighLimit?high[i]-'0' :9;
        long res=0;
        if(i<high.length-s.length){
            for(int k=down;k<=Math.min(limit,up);k++){
                res+=dfs(i+1,isLowLimit&&k==down,isHighLimit&&k==up);
            }
        }else{
            int x=s[i-(high.length-s.length)]-'0';
            if(x>=down&&x<=up){
                res+=dfs(i+1,isLowLimit&&x==down,isHighLimit&&x==up);
            }
        }
        if(!isHighLimit&&!isLowLimit)memo[i]=res;
        return res;
    }
}
