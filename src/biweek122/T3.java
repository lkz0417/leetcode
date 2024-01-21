package biweek122;

import java.util.Arrays;

public class T3 {
  public int minimumArrayLength(int[] nums) {
    Arrays.sort(nums);
    int count=1;
    boolean ok=false;
    for(int i=1;i<nums.length;i++){
      if(nums[i]==nums[0])count++;
      else if(nums[i]%nums[0]!=0){
        ok=true;
        break;
      }
    }
    if(nums[0]!=1&&count!=nums.length){
      return count<=2||ok?1:2;
    }else{
      if(count%2==0){
        return count/2;
      }else{
        return count/2+1;
      }
    }
  }

}
