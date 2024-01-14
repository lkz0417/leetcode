package week340;

import java.util.Arrays;

public class T3 {
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0,right=nums[n-1]-nums[0];
        while(left<right){
            int mid=(right-left)/2+left;
            int cnt=0;
            for(int i=0;i<n-1;i++){
                if(Math.abs(nums[i]-nums[i+1])<=mid){
                    cnt++;
                    i++;
                }
            }
            if(cnt>=p)right=mid;
            else left=mid+1;
        }
        return left;
    }
}
