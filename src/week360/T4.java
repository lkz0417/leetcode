package week360;

import java.util.List;

public class T4 {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
         int n= receiver.size();
         int m=64-Long.numberOfLeadingZeros(k);
         int[][] pa=new int[m][n];
         long[][] sum=new long[m][n];
         for(int i=0;i<n;i++){
             pa[0][i]= receiver.get(i);
             sum[0][i]= receiver.get(i);
         }
         for(int i=0;i<m-1;i++){
             for(int j=0;j<n;j++){
                 pa[i+1][j]=pa[i][pa[i][j]];
                 sum[i+1][j]=sum[i][j]+sum[i][pa[i][j]];
             }
         }
         long res=0;
         for(int i=0;i<n;i++){
             long s=i;
             int x=i;
             for(long j=k;j>0;j&=(j-1)){
                 int cnt=Long.numberOfTrailingZeros(j);
                 s+=sum[cnt][x];
                 x=pa[cnt][x];
             }
             res=Math.max(res,s);
         }
         return res;
    }
}
