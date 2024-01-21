package biweek122;

import java.util.TreeMap;

public class SlidingWindowKth {
  TreeMap<Integer,Integer> L=new TreeMap<>();
  TreeMap<Integer,Integer> R=new TreeMap<>();
  int sizeL=0;
  public double[] medianSlidingWindow(int[] nums, int k) {
       /* if(k==1){
            double[] res=new double[nums.length];
            for(int i=0;i<nums.length;i++){
                res[i]=nums[i];
            }
            return res;
        }
        */
    int size=k%2==0?k/2:k/2+1;
    for(int i=0;i<k;i++){
      L.merge(nums[i],1,Integer::sum);
    }
    sizeL=k;
    while(sizeL>size){
      l2r();
    }
    double[] res=new double[nums.length-k+1];
    if(k%2==0){
      res[0]=(L.lastKey()/2.0+R.firstKey()/2.0);
    }else{
      res[0]=L.lastKey();
    }
    for(int i=k;i<nums.length;i++){
      int out=nums[i-k];
      if(L.containsKey(out)){
        sizeL--;
        removeOne(L, out);
      }else{
        removeOne(R, out);
      }
      int in=nums[i];
      if(!L.isEmpty()&&in<L.lastKey()){
        sizeL++;
        L.merge(in,1,Integer::sum);
      }else{
        R.merge(in,1,Integer::sum);
      }
      if(sizeL==size-1){
        r2l();
      }
      if(sizeL==size+1){
        l2r();
      }
      if(k%2==0){
        res[i-k+1]=(L.lastKey()/2.0+R.firstKey()/2.0);
      }else{
        res[i-k+1]=L.lastKey();
      }
    }
    return res;
  }
  public void l2r(){
    int x=L.lastKey();
    sizeL--;
    removeOne(L, x);
    R.merge(x, 1, Integer::sum);
  }
  public void r2l(){
    int x=R.firstKey();
    sizeL++;
    removeOne(R, x);
    L.merge(x, 1, Integer::sum);
  }
  public void removeOne(TreeMap<Integer,Integer> map,int x){
    int cnt=map.get(x);
    if(cnt>1){
      map.put(x, cnt-1);
    }else{
      map.remove(x);
    }
  }

}
