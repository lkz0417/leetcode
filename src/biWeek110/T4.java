package biWeek110;

import java.util.Arrays;
import java.util.List;

public class T4 {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n=nums2.size();
        int[][] pair=new int[n][2];
        int s1=0,s2=0;
        for(int i=0;i<n;i++){
            s1+=nums1.get(i);
            s2+=nums2.get(i);
            pair[i][0]= nums1.get(i);
            pair[i][1]=nums2.get(i);
        }
        Arrays.sort(pair,(a,b)->(a[1]-b[1]));
        int[] dp=new int[n+1];
        for(int[] p:pair){
            for(int j=n;j>=1;j--){
                dp[j]=Math.max(dp[j],dp[j-1]+p[0]+p[1]*j);
            }
        }
        for(int t=0;t<=n;t++){
            if(s1+s2*t-dp[t]<=x){
                return t;
            }
        }
        return -1;
    }
}
