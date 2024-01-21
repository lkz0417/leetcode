package biweek122;

import com.sun.source.tree.Tree;
import java.util.TreeMap;

public class t4 {
  TreeMap<Integer,Integer> L=new TreeMap<>();
  TreeMap<Integer,Integer> R=new TreeMap<>();
  int sizeL=0;
  long sum=0L;
  public long minimumCost(int[] nums, int k, int dist) {
     k--;
     sum+=nums[0];
     for(int i=1;i<=dist+1;i++){
       sum+=nums[i];
       L.merge(nums[i],1,Integer::sum);
     }
     sizeL=dist+1;
     while(sizeL>k){
       l2r();
     }
     long ans=sum;
     for(int i=dist+2;i<nums.length;i++){
       int out=nums[i-dist-1];
       if(L.containsKey(out)){
         removeOne(L,out);
         sizeL--;
         sum-=out;
       }else{
         removeOne(R,out);
       }
       int in=nums[i];
       if(in<L.lastKey()){
         L.merge(in,1,Integer::sum);
         sizeL++;
         sum+=in;
       }else{
         R.merge(in,1,Integer::sum);
       }
       if(sizeL==k-1){
         r2l();
       }
       if(sizeL==k+1){
         l2r();
       }
       ans=Math.min(ans,sum);
     }
     return ans;
  }

  public void l2r(){
    int x=L.lastKey();
    removeOne(L,x);
    sum-=x;
    sizeL--;
    R.merge(x,1,Integer::sum);
  }

  public void r2l(){
    int x=R.firstKey();
    removeOne(R,x);
    sum+=x;
    sizeL++;
    L.merge(x,1,Integer::sum);
  }

  public void removeOne(TreeMap<Integer,Integer> map,int x){
    int cnt=map.get(x);
    if(cnt>1){
      map.put(x,cnt-1);
    }else{
      map.remove(x);
    }
  }

}
