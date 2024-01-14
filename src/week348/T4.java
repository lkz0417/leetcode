package week348;

import java.util.Arrays;

public class T4 {
    int min_sum,max_sum;
    int[][] memo;
    char[] c;
    final int MOD=1000000007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        this.min_sum=min_sum;
        this.max_sum=max_sum;
        int sum=0;
        int res=cal(num2)-cal(num1)+MOD;
        for (char c : num1.toCharArray()) sum += c - '0';
        if (min_sum <= sum && sum <= max_sum) res++;

        return res%MOD;

    }

    public int cal(String num){
        c=num.toCharArray();
        memo=new int[c.length][Math.min(9*c.length,max_sum)+1];
        for(int i=0;i<c.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return f(0,0,true);
    }

    public int f(int i, int sum,boolean isLimit){
        if(sum>max_sum)return 0;
        if(i==c.length){
            return sum<min_sum?0:1;
        }
        if(!isLimit&&memo[i][sum]!=-1)return memo[i][sum];
        int res=0;
        int up=isLimit?c[i]-'0':9;
        for(int k=0;k<=up;k++){
            res=(res+f(i+1,sum+k,isLimit&&k==up))%MOD;
        }
        if(!isLimit)memo[i][sum]=res;
        return res;
    }
}
