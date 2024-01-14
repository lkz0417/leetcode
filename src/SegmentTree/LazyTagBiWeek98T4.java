package SegmentTree;

public class LazyTagBiWeek98T4 {
    int[] cnt1;
    boolean[] flip;
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums1.length,m=0,index=0;
        cnt1=new int[n*4];
        flip=new boolean[n*4];
        long sum=0;
        for(int num:nums2){
            sum+=num;
        }
        for(int[] query:queries){
            if(query[0]==3){
                m++;
            }
        }
        long[] ans=new long[m];
        build(1,1,n,nums1);
        int len= queries.length;
        for(int i=0;i<len;i++){
            if(queries[i][0]==1){
                update(1,1,n,queries[i][1]+1,queries[i][2]+1);
            }else if(queries[i][0]==2){
                sum+=(long)cnt1[1]*queries[i][1];
            }else{
                ans[index++]=sum;
            }
        }
        return ans;
    }
    public void maintain(int o){
        cnt1[o]=cnt1[o*2]+cnt1[o*2+1];
    }
    public void proceed(int o,int l,int r){
        cnt1[o]=r-l+1-cnt1[o];
        flip[o]=!flip[o];
    }
    public void build(int o,int l,int r,int[] nums1){
        if(l==r){
            cnt1[o]=nums1[l-1];
            return;
        }
        int mid=(l+r)/2;
        build(o*2,l,mid,nums1);
        build(o*2+1,mid+1,r,nums1);
        maintain(o);
    }
    public void update(int o,int l,int r,int L,int R){
        if(L<=l&&R>=r){
            proceed(o,l,r);
            return;
        }
        int mid=(l+r)/2;
        if(flip[o]){
            proceed(o*2,l,mid);
            proceed(o*2+1,mid+1,r);
            flip[o]=false;
        }
        if(L<=mid){
            update(o*2,l,mid,L,R);
        }
        if(R>mid){
            update(o*2+1,mid+1,r,L,R);
        }
        maintain(o);
    }


}
