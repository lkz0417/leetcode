package SegmentTree;

public class BasicTree {
    int[] sum;
    int[] min;
    int n,m;
    public BasicTree(int n,int m){
        this.n=n;
        this.m=m;
        sum=new int[n*4];
        min=new int[n*4];
    }
    public void add(int o,int l,int r,int idx,int val){
        if(l==r){
            sum[o]+=val;
            min[o]+=val;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid){
            add(o*2,l,mid,idx,val);
        }else{
            add(o*2+1,mid+1,r,idx,val);
        }
        sum[o]=sum[o*2]+sum[o*2+1];
        min[o]=Math.min(min[o*2],min[o*2+1]);
    }
    public int query(int o,int l,int r,int L,int R){
        if(L<=l&&R>=r){
            return sum[o];
        }
        int mid=(l+r)/2;
        int res=0;
        if(L<=mid){
            res+=query(o*2,l,mid,L,R);
        }
        if(R>mid){
            res+=query(o*2+1,mid+1,r,L,R);
        }
        return res;
    }
    public int index(int o,int l,int r,int R,int val){
        if(min[o]>val)return 0;
        if(l==r)return l;
        int mid=(l+r)/2;
        if(min[o*2]<=val)return index(o*2,l,mid,R,val);
        if(R>m)return index(o*2+1,mid+1,r,R,val);
        return 0;
    }
}
