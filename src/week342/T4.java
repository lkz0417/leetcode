package week342;

public class T4 {
    public int minOperations(int[] nums) {
       int n=nums.length;
       int minGap=n,cnt0=0;
       for(int i=0;i<n;i++){
           if(nums[i]==1)cnt0++;
       }
       if(cnt0>0){
           return n-cnt0;
       }
       int[] temp=new int[n];
       for(int i=0;i<n-1;i++){
           for(int k=0;k<n;k++){
               temp[k]=nums[k];
           }
           for(int j=i;j<n;j++){
               int num=gcd(temp[j],temp[j+1]);
               if(num>1){
                   temp[j+1]=num;
               }else{
                   minGap=Math.min(minGap,j+1-i);
                   break;
               }
           }
       }
       return minGap==n?-1:minGap+n-1;

    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        if(b>a){
            int temp=a;
            a=b;
            b=temp;
        }
        return gcd(b,a%b);
    }
}
