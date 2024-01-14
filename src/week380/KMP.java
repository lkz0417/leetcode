package week380;

import java.util.ArrayList;
import java.util.List;

public class KMP {
  int[] calculateMaxMatchLengths(String pattern) {
    int n=pattern.length();
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
    return next;
  }


  List<Integer> search(String text, String pattern) {
    List<Integer> res=new ArrayList<>();
    int count=0,n=text.length();
    int[] next=calculateMaxMatchLengths(pattern);
    for(int i=0;i<n;i++){
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
