package biweek103;

import java.util.Arrays;

public class T4 {
    public long countOperationsToEmptyArray(int[] nums) {
       int n=nums.length;
       Integer[] idx=new Integer[n];
       for(int i=0;i<n;i++){
           idx[i]=i;
       }
        Arrays.sort(idx,(a,b)->(nums[a]-nums[b]));
       BIT treeArray=new BIT(n+1);
       int pre=1;
       long res=n;
       for(int k=0;k<n;k++){
           int i=idx[k]+1;
           if(pre<=i){
               res+=i-pre-treeArray.query(pre,i);
           }else{
               res+=n-pre+i-k+treeArray.query(i,pre-1);
           }
           treeArray.inc(i);
           pre=i;
       }
       return res;
    }
}
class BIT{
    int[] tree;
    public BIT(int n){
        tree=new int[n];
    }
    public void inc(int x){
        while(x<tree.length){
            tree[x]++;
            x+=(x&-x);
        }
    }
    public int sum(int x){
        int res=0;
        while(x>0){
            res+=tree[x];
            x&=(x-1);
        }
        return res;
    }
    public int query(int left,int right){
        return sum(right)-sum(left-1);
    }
}
