package week360;

import java.util.ArrayList;
import java.util.List;

public class t3 {
  public int minOperations(List<Integer> nums, int target) {
    long sum=0;
    for(int num:nums){
      sum+=num;
    }
    if(sum<target){
      return -1;
    }else if(sum==target){
      return 0;
    }
    String s=Integer.toBinaryString(target);
    int[] goal=new int[32];
    for(int i=0;i<s.length();i++){
      if(s.charAt(s.length()-i-1)=='1'){
        goal[i]=1;
      }
    }
    int[] binary=new int[32];
    for(int num:nums){
      String temp=Integer.toBinaryString(num);
      for(int i=0;i<temp.length();i++){
        if(temp.charAt(temp.length()-i-1)=='1'){
          binary[i]++;
        }
      }
    }
    List<Integer> list=new ArrayList<>();
    for(int i=0;i<32;i++){
      if(goal[i]<=binary[i]){
        if(goal[i]!=0){
          binary[i]--;
        }
        goal[i]=0;
      }else{
        list.add(i);
      }
    }
    int res=0;
    for(int i=0;i<list.size();i++){
      int pos=list.get(i);
      for(int j=i==0?0:list.get(i-1);j<pos;j++){
        if(binary[j]>=2){
          if(binary[j]%2==0){
            binary[j+1]+=binary[j]/2;
            binary[j]=0;
          }else{
            binary[j+1]+=binary[j]/2;
            binary[j]=1;
          }
        }
      }
      if(binary[pos]>=1){
        binary[pos]--;
        continue;
      }
      int next=pos+1;
      for(;next<32;next++){
        if(binary[next]!=0)break;
      }
      for(int j=next;j>pos;j--){
        res++;
        binary[j]--;
        binary[j-1]+=2;
      }
      binary[pos]--;
    }
    return res;
  }

}
