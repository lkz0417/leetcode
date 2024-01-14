package biWeek111;

import java.util.Arrays;

public class T4 {
    char[] s;
    int[][][] memo;
    int k;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k=k;
        return cal(high)-cal(low-1);
    }
    public int cal(int x){
        s=Integer.toString(x).toCharArray();
        int n=s.length;
        memo=new int[n][k][2*n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return dfs(0,0,n,true,false);
    }

    public int dfs(int i,int val,int diff,boolean isLimit,boolean isNum){
        if(i==s.length){
            return diff==s.length&&val==0&&isNum? 1:0;
        }
        if(!isLimit&&isNum&&memo[i][val][diff]!=-1)return memo[i][val][diff];
        int res=0;
        if(!isNum){
            res=dfs(i+1,val,diff,false,false);
        }
        int up=isLimit?s[i]-'0':9;
        for(int p=isNum?0:1;p<=up;p++){
            res+=dfs(i+1,(10*val+p)%k,diff+p%2*2-1,isLimit&&p==up,true);
        }
        if(!isLimit&&isNum)memo[i][val][diff]=res;
        return res;
    }
}
