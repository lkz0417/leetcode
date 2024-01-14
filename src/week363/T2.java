package week363;

import java.util.Collections;
import java.util.List;

public class T2 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int num=0,res=0;
        for(int i=0;i<nums.size()-1;i++){
            num++;
            if(num>nums.get(i)&&num<nums.get(i+1))res++;
        }
        if(nums.get(0)>0)res++;
        if(nums.get(nums.size()-1)>nums.size())res++;
        return res;
    }
}
