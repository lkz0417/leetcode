package biWeek109;

public class T3 {
    public long maxScore(int[] nums, int x) {
        int n=nums.length;
        int[] dp=new int[n];
        int maxOdd=0,maxEven=0;
        if(nums[0]%2==0){
            dp[0]=nums[0];
            maxEven=nums[0];
        }else{
            dp[0]=nums[0];
            maxOdd=nums[0];
        }
        for(int i=1;i<n;i++){
            if(nums[i]%2==0){
                dp[i]=Math.max(maxEven+nums[i],maxOdd+nums[i]-x);
                if(dp[i]>maxEven)maxEven=dp[i];
            }else{
                dp[i]=Math.max(maxOdd+nums[i],maxEven+nums[i]-x);
                if(dp[i]>maxOdd)maxOdd=dp[i];
            }
        }
        return Math.max(maxEven,maxOdd);
    }
}
