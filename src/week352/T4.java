package week352;

import java.util.Arrays;

public class T4 {
    public int sumImbalanceNumbers(int[] nums) {
       int n=nums.length;
       int[] idx=new int[n+1];
       int[] right=new int[n];
        Arrays.fill(idx,n);
        for(int i=n-1;i>=0;i--){
            int x=nums[i];
            right[i]=Math.min(idx[x],idx[x-1]);
            idx[x]=i;
        }
        Arrays.fill(idx,-1);
        int res=0;
        for(int i=0;i<n;i++){
            int x=nums[i];
            res+=(right[i]-i)*(i-idx[x-1]);
            idx[x]=i;
        }
        return res-(n+1)*n/2;
    }
}
