package week380;

import java.util.ArrayList;
import java.util.List;

public class T4 {
  List<Integer> posA;
  List<Integer> posB;
  public List<Integer> beautifulIndices(String s, String a, String b, int k) {
     posA=kmp(s,a);
     posB=kmp(s,b);
     int j=0;
     int m=posB.size();
     List<Integer> ans=new ArrayList<>();
     for(int i:posA){
       while(j<m&&posB.get(j)<i-k){
         j++;
       }
       if(j<m&&Math.abs(posB.get(j)-i)<=k){
         ans.add(i);
       }
     }
     return ans;
  }

  public List<Integer> kmp(String text,String pattern){
    int n=pattern.length();
    List<Integer> res=new ArrayList<>();
    int[] next=new int[n];
    int maxLength=0;
    for(int i=1;i<n;i++){
      while(maxLength>0&&pattern.charAt(i)!=pattern.charAt(maxLength)){
        maxLength=next[maxLength-1];
      }
      if(pattern.charAt(maxLength)==pattern.charAt(i)){
        maxLength++;
      }
      next[i]=maxLength;
    }
    int count=0;
    for(int i=0;i<text.length();i++){
      while(count>0&&text.charAt(i)!=pattern.charAt(count)){
        count=next[count-1];
      }
      if(pattern.charAt(count)==text.charAt(i)){
        count++;
      }
      if(count==pattern.length()){
        res.add(i-pattern.length()+1);
        count=next[count-1];
      }
    }
    return res;
  }

}
