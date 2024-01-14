package biWeek113;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T2 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maximum=0,total=nums.size();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            maximum=Math.max(maximum,map.get(num));
        }
        if(maximum>total/2){
            return maximum*2-total;
        }else{
            if(total%2==1)return 1;
            else return 0;
        }
    }
}
